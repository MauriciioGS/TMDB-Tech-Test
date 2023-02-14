package mx.mauriciogs.storage.movies.data.api

import mx.mauriciogs.storage.movies.data.api.MoviesEndPoint.GET.NOW_PLAYING
import mx.mauriciogs.storage.movies.data.api.MoviesEndPoint.GET.POPULAR
import mx.mauriciogs.storage.movies.data.models.ResponseMostPopularMovies
import mx.mauriciogs.storage.movies.data.models.ResponseNowPlayingMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET(NOW_PLAYING)
    suspend fun playingNow(@Path("api_key") apiKey: String, @Path("num_page") page: Int): Response<ResponseNowPlayingMovies>

    @GET(POPULAR)
    suspend fun popular(@Path("api_key") apiKey: String, @Path("num_page") page: Int): Response<ResponseMostPopularMovies>

}