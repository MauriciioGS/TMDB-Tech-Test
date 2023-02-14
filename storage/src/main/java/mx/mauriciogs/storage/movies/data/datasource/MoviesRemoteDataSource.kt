package mx.mauriciogs.storage.movies.data.datasource

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import mx.mauriciogs.storage.BuildConfig
import mx.mauriciogs.storage.coroutines.IODispatcher
import mx.mauriciogs.storage.movies.data.api.MoviesApi
import mx.mauriciogs.storage.movies.data.models.ResponseNowPlayingMovies
import mx.mauriciogs.storage.common.Result
import mx.mauriciogs.storage.movies.data.api.MoviesEndPoint
import mx.mauriciogs.storage.movies.exception.MoviesException
import mx.mauriciogs.storage.movies.data.models.ResponseMostPopularMovies
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(private val api: MoviesApi,
                                                 @IODispatcher private val dispatcher: CoroutineDispatcher) {

    private val API_KEY = BuildConfig.API_KEY

    suspend fun getPlayingNow(page: Int): Result<ResponseNowPlayingMovies> {
        val result = withContext(dispatcher) {
            try {
                Log.d("API_KEY", "$page")
                val response = api.playingNow(API_KEY, page)
                response.body()
            } catch (exception: Exception) {
                return@withContext null
            }
        }

        if(result != null) return Result.Success(result)

        Log.e("ERROR", "Error Server petition")
        return Result.Error(MoviesException.ErrorUnknownMessage("Error Server"))
    }


    suspend fun getMostPopular(page: Int): Result<ResponseMostPopularMovies> {
        val result = withContext(dispatcher) {
            try {
                val response = api.popular(API_KEY, page)
                response.body()
            } catch (exception: Exception) {
                return@withContext null
            }
        }

        if(result != null) return Result.Success(result)

        return Result.Error(MoviesException.ErrorUnknownMessage("Error Server"))
    }
}