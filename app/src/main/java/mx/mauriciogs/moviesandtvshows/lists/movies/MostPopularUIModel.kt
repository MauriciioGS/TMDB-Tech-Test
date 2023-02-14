package mx.mauriciogs.moviesandtvshows.lists.movies

import mx.mauriciogs.storage.movies.data.models.Movie

data class MostPopularUIModel (val showProgress: Boolean, val exception: Exception? = null, val showSuccess: List<Movie>? = null)