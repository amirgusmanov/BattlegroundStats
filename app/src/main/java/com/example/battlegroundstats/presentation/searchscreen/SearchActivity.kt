package com.example.battlegroundstats.presentation.searchscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.ActivitySearchBinding
import com.example.battlegroundstats.presentation.mainscreen.MainActivity

class SearchActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySearchBinding
    private val navController by lazy { findNavController(R.id.nav_host_fragment_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.search_button -> {
                val text = binding.editText.text.toString().trim()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("key", text)
                startActivity(intent)
            }
        }
    }

}
