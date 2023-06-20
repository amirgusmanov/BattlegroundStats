package com.example.battlegroundstats.presentation.ui.main.lifetime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.battlegroundstats.data.repository.RepositoryRemoteImpl
import com.example.battlegroundstats.data.sources.remote.mapper.RemotePlayerMapper
import com.example.battlegroundstats.domain.interactor.GetPlayerLifetimeStatsUseCase
import com.example.battlegroundstats.domain.models.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val getPlayerLifetimeStatsUseCase: GetPlayerLifetimeStatsUseCase
) : ViewModel() {

    private val _playerStats: MutableLiveData<Flow<Player>> = MutableLiveData()
    val playerStats
        get() = _playerStats

    fun getPlayerStats(nickname: String, platform: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val stats = getPlayerLifetimeStatsUseCase(nickname, platform)
            _playerStats.postValue(stats)
        }
    }

    //test factory while di is not working
    companion object {
        fun factory() = viewModelFactory {
            initializer {
                val useCase = GetPlayerLifetimeStatsUseCase(RepositoryRemoteImpl(RemotePlayerMapper()))
                HomeFragmentViewModel(useCase)
            }
        }
    }

}
