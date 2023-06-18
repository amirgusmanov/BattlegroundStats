package com.example.battlegroundstats.presentation.mainscreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.ActivityMainBinding
import com.example.battlegroundstats.presentation.mainscreen.lifetime.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("key")
        Toast.makeText(this, "$name", Toast.LENGTH_SHORT).show()

        val homeFragment = name?.let { HomeFragment.newInstance(it) }
        if (homeFragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment_container, homeFragment)
                .commit()
        }
    }
}