package mx.mauriciogs.storage.movies.domain

import mx.mauriciogs.storage.movies.data.MoviesRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {

    suspend fun fetchPlayingNowMovies(page: Int = 1) = moviesRepository.getPlayingNow(page)

    suspend fun fetchMostPopularMovies(page: Int = 1) = moviesRepository.getMostPopular(page)

}