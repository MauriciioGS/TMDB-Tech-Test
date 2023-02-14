package mx.mauriciogs.storage.movies.data

import mx.mauriciogs.storage.common.Result
import mx.mauriciogs.storage.movies.data.datasource.MoviesRemoteDataSource
import mx.mauriciogs.storage.movies.data.models.ResponseMostPopularMovies
import mx.mauriciogs.storage.movies.data.models.ResponseNowPlayingMovies
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesRemoteDataSource: MoviesRemoteDataSource) {

    suspend fun getPlayingNow(page: Int): Result<ResponseNowPlayingMovies> {
        return moviesRemoteDataSource.getPlayingNow(page)
    }

    suspend fun getMostPopular(page: Int): Result<ResponseMostPopularMovies> {
        return moviesRemoteDataSource.getMostPopular(page)
    }

}
