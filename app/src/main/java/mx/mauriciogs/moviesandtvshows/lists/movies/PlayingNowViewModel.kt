package mx.mauriciogs.moviesandtvshows.lists.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import mx.mauriciogs.storage.common.Result
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.mauriciogs.storage.coroutines.CoroutinesDispatchers
import mx.mauriciogs.storage.movies.data.models.Movie
import mx.mauriciogs.storage.movies.data.models.ResponseNowPlayingMovies
import mx.mauriciogs.storage.movies.domain.MoviesUseCase
import mx.mauriciogs.storage.movies.exception.MoviesException
import javax.inject.Inject

private const val TAG = "PLAYING_NOW_VM"

@HiltViewModel
class PlayingNowViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase,
                                              private val coroutineDispatcher: CoroutinesDispatchers): ViewModel() {

    private var cursor = 1
    private var moviesList: List<Movie> = emptyList()

    fun getPlayingNowMovies() {
        viewModelScope.launch(coroutineDispatcher.io) {
            Log.d(TAG, "hacer fetch")
            val result = moviesUseCase.fetchPlayingNowMovies(cursor)
            withContext(coroutineDispatcher.main) {
                when (result) {
                    is Result.Success -> moviesListSuccess(result.data)
                    is Result.Error -> {
                        Log.d(TAG, "Error en la petición")
                    }
                }
            }
        }
    }

    private fun moviesListSuccess(responsePlayingNowMovies: ResponseNowPlayingMovies) = responsePlayingNowMovies.run {
        if (results.isEmpty() && moviesList.isEmpty()) {
            MoviesException.ListMoviesEmptyMessage("Lista Vacía")
            Log.e(TAG, "Lista vacìa")
        } else {
            moviesList = moviesList + results
            cursor += 1
            println(moviesList)
        }
    }

    private fun moviesListError(exception: Exception ) {
        exception.printStackTrace()

    }
}

