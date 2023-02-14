package mx.mauriciogs.moviesandtvshows.lists.movies

import com.google.android.material.tabs.TabLayoutMediator
import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.common.BaseFrag
import mx.mauriciogs.moviesandtvshows.databinding.FragmentMoviesBinding
import mx.mauriciogs.moviesandtvshows.lists.movies.adapters.VpMoviesAdapter

class MoviesFragment: BaseFrag<FragmentMoviesBinding>(R.layout.fragment_movies) {

    private lateinit var mBinding: FragmentMoviesBinding

    override fun FragmentMoviesBinding.initialize() {
        mBinding = this
        initTab()
    }

    private fun initTab() {
        with(mBinding) {
            val adapter = VpMoviesAdapter(this@MoviesFragment)
            adapter.addFragment(PlayingNowFragment())
            adapter.addFragment(MostPopularFragment())
            viewPager2.adapter = adapter

            val titles = arrayOf(resources.getString(R.string.text_playing_now), resources.getString(R.string.text_most_popular))
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = titles[position]
            }.attach()
        }
    }
}