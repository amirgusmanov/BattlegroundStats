package com.example.battlegroundstats.presentation.di

import com.example.battlegroundstats.data.repository.RepositoryLocalImpl
import com.example.battlegroundstats.domain.interactor.GetPlayerLifetimeStatsUseCase
import com.example.battlegroundstats.domain.interactor.GetPlayerMatchesUseCase
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentViewModel
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RepositoryLocalImpl(get()) }

    factory { GetPlayerLifetimeStatsUseCase(get()) }
    factory { GetPlayerMatchesUseCase(get(), get()) }

    viewModel { HomeFragmentViewModel(get()) }
    viewModel { MatchesViewModel(get()) }
}