package mx.mauriciogs.moviesandtvshows.lists.tvshows

import com.google.android.material.tabs.TabLayoutMediator
import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.databinding.FragmentTvshowsBinding
import mx.mauriciogs.moviesandtvshows.lists.movies.adapter.VpMoviesAdapter

class TvShowsFragment: BaseFrag<FragmentTvshowsBinding>(R.layout.fragment_tvshows) {

    private lateinit var mBinding: FragmentTvshowsBinding

    override fun FragmentTvshowsBinding.initialize() {
        mBinding = this
        initTab()
    }

    private fun initTab() {
        with(mBinding) {
            val adapter = VpMoviesAdapter(this@TvShowsFragment)
            adapter.addFragment(OnTheAirFragment())
            adapter.addFragment(PopularFragment())
            viewPager2.adapter = adapter

            val titles = arrayOf(resources.getString(R.string.text_playing_now_tv), resources.getString(R.string.text_most_popular_tv))
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = titles[position]
            }.attach()
        }
    }
}