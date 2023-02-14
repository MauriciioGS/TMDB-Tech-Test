package mx.mauriciogs.moviesandtvshows.lists.movies

import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.databinding.FragmentPlayingNowBinding

class PlayingNowFragment: BaseFrag<FragmentPlayingNowBinding>(R.layout.fragment_playing_now) {

    private lateinit var mBinding: FragmentPlayingNowBinding

    override fun FragmentPlayingNowBinding.initialize() {
        mBinding = this
    }
}