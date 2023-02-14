package mx.mauriciogs.moviesandtvshows.lists.movies.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.mauriciogs.storage.common.Result
import mx.mauriciogs.storage.coroutines.CoroutinesDispatchers
import mx.mauriciogs.storage.movies.data.models.Movie
import mx.mauriciogs.storage.movies.data.models.ResponseMostPopularMovies
import mx.mauriciogs.storage.movies.domain.MoviesUseCase
import mx.mauriciogs.storage.movies.exception.MoviesException
import javax.inject.Inject

private const val TAG = "MOST_POPULAR_VM"

@HiltViewModel
class MostPopularViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase,
                                               private val coroutineDispatcher: CoroutinesDispatchers) : ViewModel() {

    private var cursor = 1
    private var moviesList: List<Movie> = emptyList()

    private val _mostPopularUiModel = MutableLiveData<MostPopularUIModel>()
    val mostPopularUiModel : LiveData<MostPopularUIModel>
        get() = _mostPopularUiModel

    fun getMostPopularMovies() {
        emitUiState(showProgress = true)
        viewModelScope.launch(coroutineDispatcher.io) {
            Log.d(TAG, "hacer fetch")
            val result = moviesUseCase.fetchMostPopularMovies(cursor)
            withContext(coroutineDispatcher.main) {
                when (result) {
                    is Result.Success -> moviesListSuccess(result.data)
                    is Result.Error -> moviesListError(result.exception)
                }
            }
        }
    }

    private fun moviesListSuccess(responsePlayingNowMovies: ResponseMostPopularMovies) = responsePlayingNowMovies.run {
        if (results.isEmpty() && moviesList.isEmpty()) {
            emitUiState(exception = MoviesException.ListMoviesEmptyMessage("No se encontraron películas"))
        } else {
            moviesList = moviesList + results
            cursor += 1
            emitUiState(showSuccess = moviesList)
        }
    }

    private fun moviesListError(exception: Exception ) {
        exception.printStackTrace()
        emitUiState(exception = exception)
    }

    private fun emitUiState(showProgress: Boolean = false, exception: Exception? = null, showSuccess: List<Movie>? = null) {
        val popularUiModel = MostPopularUIModel(showProgress, exception, showSuccess)
        _mostPopularUiModel.value = popularUiModel
    }
}