package mx.mauriciogs.storage.movies.exception

sealed class MoviesException(override val message: String?) : Exception() {
    object ErrorUnknown : MoviesException("unknown error")
    data class ErrorUnknownMessage(override val message: String?) : MoviesException(message)

    object ListMoviesEmpty : MoviesException("unknown error")
    data class ListMoviesEmptyMessage(override val message: String?) : MoviesException(message)
}