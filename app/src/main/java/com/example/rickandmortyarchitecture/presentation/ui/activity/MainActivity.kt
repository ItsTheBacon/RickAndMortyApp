package com.example.rickandmortyarchitecture.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationItemReselectListener: OnBottomNavigationItemReselect

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.characterFragment,
            R.id.episodesFragment,
            R.id.locationFragment
        ).build()
        with(binding.bottomNavRick) {
            setupWithNavController(navController)
            setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.characterFragment,
                    R.id.episodesFragment,
                    R.id.locationFragment -> {
                        bottomNavigationItemReselectListener.onItemReselect()
                    }
                }
            }
        }
        NavigationUI.setupWithNavController(binding.toolbarMain, navController, appBarConfiguration)

    }

    fun interface OnBottomNavigationItemReselect {
        fun onItemReselect()
    }

    fun setOnBottomNavigationItemReselectListener(bottomNavigationItemReselectListener: OnBottomNavigationItemReselect) {
        this.bottomNavigationItemReselectListener = bottomNavigationItemReselectListener
    }
}