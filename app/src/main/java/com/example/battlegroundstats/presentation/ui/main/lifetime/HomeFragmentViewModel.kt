package com.example.battlegroundstats.presentation.ui.main.lifetime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.battlegroundstats.data.repository.RepositoryRemoteImpl
import com.example.battlegroundstats.data.sources.remote.mapper.RemotePlayerMapper
import com.example.battlegroundstats.domain.interactor.GetPlayerLifetimeStatsUseCase
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentStatus.DONE
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentStatus.LOADING
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val getPlayerLifetimeStatsUseCase: GetPlayerLifetimeStatsUseCase
) : ViewModel() {

    private val _status: MutableLiveData<HomeFragmentStatus> = MutableLiveData()
    val status: LiveData<HomeFragmentStatus>
        get() = _status
    private val _playerStats: MutableLiveData<Flow<Player>> = MutableLiveData()
    val playerStats: LiveData<Flow<Player>>
        get() = _playerStats

    //TODO: stats are not working when switching between another and home fragment
    fun getPlayerStats(nickname: String, platform: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _status.postValue(LOADING)
            val stats = getPlayerLifetimeStatsUseCase(nickname, platform)
            _playerStats.postValue(stats)
            delay(2000)
            _status.postValue(DONE)
        }
    }

    //TODO: test factory while di is not working
    companion object {
        fun factory() = viewModelFactory {
            initializer {
                val useCase =
                    GetPlayerLifetimeStatsUseCase(RepositoryRemoteImpl(RemotePlayerMapper()))
                HomeFragmentViewModel(useCase)
            }
        }
    }

}
