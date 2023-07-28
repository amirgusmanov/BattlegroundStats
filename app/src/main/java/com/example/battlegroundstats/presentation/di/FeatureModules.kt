package com.example.battlegroundstats.presentation.di

import com.example.battlegroundstats.data.repository.RepositoryLocalImpl
import com.example.battlegroundstats.data.repository.RepositoryRemoteImpl
import com.example.battlegroundstats.data.sources.local.db.AppDatabase
import com.example.battlegroundstats.data.sources.local.mapper.LocalMatchMapper
import com.example.battlegroundstats.data.sources.local.mapper.LocalPlayerMapper
import com.example.battlegroundstats.data.sources.remote.api.ApiClient
import com.example.battlegroundstats.data.sources.remote.mapper.RemoteMatchMapper
import com.example.battlegroundstats.data.sources.remote.mapper.RemotePlayerMapper
import com.example.battlegroundstats.domain.interactor.GetPlayerLifetimeStatsUseCase
import com.example.battlegroundstats.domain.interactor.GetPlayerMatchesUseCase
import com.example.battlegroundstats.domain.repository.PubgLocalRepository
import com.example.battlegroundstats.domain.repository.PubgRemoteRepository
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentViewModel
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    viewModel { MatchesViewModel(getPlayerMatchesUseCase = get()) }
    viewModel { HomeFragmentViewModel(getPlayerLifetimeStatsUseCase = get()) }

    factory {
        GetPlayerLifetimeStatsUseCase(
            repository = get()
        )
    }

    factory {
        GetPlayerMatchesUseCase(
            localRepository = get(),
            remoteRepository = get()
        )
    }

    single {
        RepositoryLocalImpl(
            db = AppDatabase.getDatabase(androidContext()),
            matchMapper = LocalMatchMapper(),
            playerMapper = LocalPlayerMapper()
        )
    } bind PubgLocalRepository::class

    single {
        RepositoryRemoteImpl(
            playerMapper = RemotePlayerMapper(),
            matchMapper = RemoteMatchMapper(),
            api = ApiClient.pubgService()
        )
    } bind PubgRemoteRepository::class
}