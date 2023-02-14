package mx.mauriciogs.moviesandtvshows.lists.movies.detail

import com.bumptech.glide.Glide
import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.common.IMAGES_URL
import mx.mauriciogs.moviesandtvshows.databinding.FragmentMovieDetailBinding
import mx.mauriciogs.storage.movies.domain.Movie

class MovieDetailFragment: BaseFrag<FragmentMovieDetailBinding>(R.layout.fragment_movie_detail) {

    private lateinit var mBinding: FragmentMovieDetailBinding

    private lateinit var movieSelected: Movie

    override fun FragmentMovieDetailBinding.initialize() {
        mBinding = this
        movieSelected = MovieDetailFragmentArgs.fromBundle(requireArguments()).movieSel
        with(mBinding) {
            tvTitle.text = movieSelected.title
            tvOverview.text = movieSelected.overview
            tvlanguaje.text = "Idioma: ${movieSelected.original_language}"
            tvDate.text = movieSelected.release_date
            tvVoteAverage.text = "Promedio de votos: ${movieSelected.vote_average}"

            Glide.with(root.context)
                .load("$IMAGES_URL${movieSelected.poster_path}")
                .centerCrop()
                .into(ivBackdrop)
        }
    }
}