package com.example.battlegroundstats.presentation.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.battlegroundstats.R
import com.example.battlegroundstats.presentation.searchscreen.SearchActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        /**
         * TODO
         * If database is empty switch activity to the search activity, otherwise
         * switch the home fragment on the main activity
         */
        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this, SearchActivity::class.java))
            finish()
        }, 2000)
    }
}