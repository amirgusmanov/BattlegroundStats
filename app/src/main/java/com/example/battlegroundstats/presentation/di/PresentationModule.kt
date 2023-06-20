//package com.example.battlegroundstats.presentation.di
//
//import com.example.battlegroundstats.domain.interactor.GetPlayerLifetimeStatsUseCase
//import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentViewModel
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//
//@Module
//@InstallIn(ViewModelComponent::class)
//object PresentationModule {
//
//    @Provides
//    fun provideHomeFragmentViewModel(getPlayerLifetimeStatsUseCase: GetPlayerLifetimeStatsUseCase): HomeFragmentViewModel {
//        return HomeFragmentViewModel(getPlayerLifetimeStatsUseCase)
//    }
//
//}