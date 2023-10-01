package com.example.battlegroundstats.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.ActivityMainBinding
import com.example.battlegroundstats.presentation.base.binding.viewBinding
import com.example.battlegroundstats.presentation.base.constants.IntentConstants
import com.example.battlegroundstats.presentation.model.UserFields
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragment
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        setupNavigation()
        binding.bottomNavView.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navController = navHostFragment.navController
        when (item.itemId) {
            R.id.navigation_player -> {
                navController.navigate(R.id.homeFragment)
                binding.toolbar.title = getString(R.string.lifetime)
            }

            R.id.recent_matches -> {
                navController.navigate(R.id.recentMatchesFragment)
                binding.toolbar.title = getString(R.string.matches)
            }
        }
        return true
    }

    //think about when data need to be downloaded
    private fun initScreen() {
        supportFragmentManager
            .beginTransaction()
            .add<HomeFragment>(
                containerViewId = R.id.nav_host_fragment_container,
                args = intent.extras?.getBundle(IntentConstants.SEARCH_ARGS)
            )
            .commit()
    }

    private fun setupNavigation() {
        val navController = navHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}