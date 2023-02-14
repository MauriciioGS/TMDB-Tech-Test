package mx.mauriciogs.moviesandtvshows.lists.movies.popular

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.common.extensions.snackbar
import mx.mauriciogs.moviesandtvshows.databinding.FragmentMostPopularBinding
import mx.mauriciogs.moviesandtvshows.lists.movies.adapters.PopularTvAdapter
import mx.mauriciogs.storage.movies.data.models.Movie

class MostPopularFragment: BaseFrag<FragmentMostPopularBinding>(R.layout.fragment_most_popular) {

    private lateinit var mBinding: FragmentMostPopularBinding

    private val mostPopularViewModel: MostPopularViewModel by activityViewModels()

    override fun FragmentMostPopularBinding.initialize() {
        mBinding = this
        mostPopularViewModel.getMostPopularMovies()
        initObservers()
    }

    private fun initObservers() {
        mostPopularViewModel.mostPopularUiModel.observe(viewLifecycleOwner) {
            if (it.showProgress) showProgressDialog() else hideProgressDialog()
            if (it.exception != null) showError(it.exception)
            if (it.showSuccess != null) initUI(it.showSuccess)
        }
    }

    private fun showError(exception: Exception) {
        snackbar(exception.message)
    }

    private fun initUI(movies: List<Movie>) {
        println(movies)
        with(mBinding) {
            rvMovies.apply {
                layoutManager = GridLayoutManager(requireActivity(), 2)
                adapter = PopularTvAdapter(movies, this@MostPopularFragment)
            }
        }
    }

    fun onClickItem(movie: Movie) {

    }
}