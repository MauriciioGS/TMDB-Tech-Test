package mx.mauriciogs.moviesandtvshows.lists.movies.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class VpMoviesAdapter(frag: Fragment): FragmentStateAdapter(frag) {

    private val fragList: MutableList<Fragment> = arrayListOf()

    fun addFragment(fragment: Fragment) {
        fragList.add(fragment)
    }

    override fun getItemCount(): Int = fragList.size

    override fun createFragment(position: Int): Fragment = fragList[position]

}