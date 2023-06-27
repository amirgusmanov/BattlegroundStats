package com.example.battlegroundstats.presentation.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PubgApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PubgApplication)
            modules(appModule)
        }
    }

}