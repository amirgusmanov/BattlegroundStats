package com.example.battlegroundstats

import android.app.Application
import com.example.battlegroundstats.presentation.di.appModule
import com.example.battlegroundstats.presentation.di.matchesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PubgApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PubgApplication)
            modules(appModule, matchesModule)
        }
    }
}