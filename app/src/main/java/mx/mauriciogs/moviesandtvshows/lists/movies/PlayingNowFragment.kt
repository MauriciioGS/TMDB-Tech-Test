package mx.mauriciogs.moviesandtvshows.lists.movies

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.common.extensions.snackbar
import mx.mauriciogs.moviesandtvshows.databinding.FragmentPlayingNowBinding
import mx.mauriciogs.moviesandtvshows.lists.movies.adapters.PlayingNowAdapter
import mx.mauriciogs.storage.movies.data.models.Movie

@AndroidEntryPoint
class PlayingNowFragment: BaseFrag<FragmentPlayingNowBinding>(R.layout.fragment_playing_now) {

    private lateinit var mBinding: FragmentPlayingNowBinding

    private val playingNowViewModel: PlayingNowViewModel by activityViewModels()

    override fun FragmentPlayingNowBinding.initialize() {
        mBinding = this
        playingNowViewModel.getPlayingNowMovies()
        initObservers()
    }

    private fun initObservers() {
        playingNowViewModel.playingNowUiModel.observe(viewLifecycleOwner) {
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
                adapter = PlayingNowAdapter(movies, this@PlayingNowFragment)
            }
        }
    }

    fun onClickItem(movie: Movie) {

    }
}