package com.example.battlegroundstats.presentation.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        setupNavigation()
        binding.bottomNavView.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navController = navHostFragment.navController
        when (item.itemId) {
            R.id.navigation_player -> navController.navigate(R.id.homeFragment)
            R.id.recent_matches -> navController.navigate(R.id.recentMatchesFragment)
        }
        return true
    }

    private fun setupNavigation() {
        val navController = navHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.searchFragment) {
                hideUI()
            } else {
                showUI()
            }
        }
    }

    private fun showUI() {
        binding.bottomNavView.visibility = View.VISIBLE
        binding.toolbar.visibility = View.VISIBLE
    }

    private fun hideUI() {
        binding.bottomNavView.visibility = View.GONE
        binding.toolbar.visibility = View.GONE
    }
}