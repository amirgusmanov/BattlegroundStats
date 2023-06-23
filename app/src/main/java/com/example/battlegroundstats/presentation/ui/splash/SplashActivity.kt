package com.example.battlegroundstats.presentation.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.battlegroundstats.R
import com.example.battlegroundstats.presentation.ui.main.MainActivity

/*
 TODO:
  1. Add a single navigation graph to rule them all (activities and fragments)
  2. Put the arguments through the nav graph
  3. (?) Remove `-screen` suffix
  4.
 */
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
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }
}