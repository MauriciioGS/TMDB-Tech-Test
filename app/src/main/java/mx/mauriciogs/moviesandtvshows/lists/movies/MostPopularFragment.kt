package mx.mauriciogs.moviesandtvshows.lists.movies

import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.databinding.FragmentMostPopularBinding

class MostPopularFragment: BaseFrag<FragmentMostPopularBinding>(R.layout.fragment_most_popular) {

    private lateinit var mBinding: FragmentMostPopularBinding

    override fun FragmentMostPopularBinding.initialize() {
        mBinding = this
    }
}