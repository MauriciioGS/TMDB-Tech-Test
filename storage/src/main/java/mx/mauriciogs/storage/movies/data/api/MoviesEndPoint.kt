package mx.mauriciogs.storage.movies.data.api

object MoviesEndPoint {

    object GET {
        const val NOW_PLAYING = "/movie/now_playing?api_key={api_key}&page={num_page}"
        const val POPULAR = "/movie/popular?api_key={api_key}&page={num_page}"
    }
}