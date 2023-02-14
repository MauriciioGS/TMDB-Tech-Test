package mx.mauriciogs.moviesandtvshows.main

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import mx.mauriciogs.moviesandtvshows.R
import mx.mauriciogs.moviesandtvshows.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView
    private val navHost : NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navHostFrag) as NavHostFragment }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        navController = navHost.navController
        bottomNav = findViewById(R.id.bottomNav)

        with(binding) {
            bottomNav.itemIconTintList = null
            bottomNav.itemActiveIndicatorColor = null
            bottomNav.itemTextColor = myColorList
            bottomNav.setupWithNavController(navController)
        }
    }

    companion object {
        val states = arrayOf(
            intArrayOf(android.R.attr.state_enabled), // enabled
            intArrayOf(android.R.attr.state_enabled), // disabled
            intArrayOf(android.R.attr.state_checked), // unchecked
            intArrayOf(android.R.attr.state_pressed)  // pressed
        )

        val colors = intArrayOf(
            Color.GRAY,
            Color.GRAY,
            Color.WHITE,
            Color.WHITE
        )

        val myColorList = ColorStateList(states, colors)
    }

}