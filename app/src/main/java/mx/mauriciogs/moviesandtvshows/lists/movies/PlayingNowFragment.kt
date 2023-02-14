package mx.mauriciogs.moviesandtvshows.lists.movies

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.databinding.FragmentPlayingNowBinding

@AndroidEntryPoint
class PlayingNowFragment: BaseFrag<FragmentPlayingNowBinding>(R.layout.fragment_playing_now) {

    private lateinit var mBinding: FragmentPlayingNowBinding

    private val playingNowViewModel: PlayingNowViewModel by activityViewModels()

    override fun FragmentPlayingNowBinding.initialize() {
        mBinding = this
        playingNowViewModel.getPlayingNowMovies()
    }
}