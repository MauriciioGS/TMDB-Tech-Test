package mx.mauriciogs.moviesandtvshows.lists.tvshows

import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.databinding.FragmentPopularTvShowsBinding

class PopularFragment: BaseFrag<FragmentPopularTvShowsBinding>(R.layout.fragment_popular_tv_shows) {

    private lateinit var mBinding: FragmentPopularTvShowsBinding

    override fun FragmentPopularTvShowsBinding.initialize() {
        mBinding = this
    }
}