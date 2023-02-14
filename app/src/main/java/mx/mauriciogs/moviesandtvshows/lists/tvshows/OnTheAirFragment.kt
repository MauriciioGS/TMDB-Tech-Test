package mx.mauriciogs.moviesandtvshows.lists.tvshows

import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.databinding.FragmentOnTheAirBinding

class OnTheAirFragment: BaseFrag<FragmentOnTheAirBinding>(R.layout.fragment_on_the_air) {

    private lateinit var mBinding: FragmentOnTheAirBinding

    override fun FragmentOnTheAirBinding.initialize() {
        mBinding = this
    }
}