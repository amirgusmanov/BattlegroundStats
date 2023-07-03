package com.example.battlegroundstats.presentation.ui.main.lifetime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.battlegroundstats.domain.interactor.GetPlayerLifetimeStatsUseCase
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentState.Loading
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentState.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

sealed interface HomeFragmentState {
    object Loading : HomeFragmentState
    data class Success(val data: Player) : HomeFragmentState
    data class Error(val error: Throwable) : HomeFragmentState
}

class HomeFragmentViewModel(
    private val getPlayerLifetimeStatsUseCase: GetPlayerLifetimeStatsUseCase
) : ViewModel() {

    private val _playerStats: MutableLiveData<HomeFragmentState> = MutableLiveData()
    val playerStats: LiveData<HomeFragmentState>
        get() = _playerStats

    fun getPlayerStats(nickname: String, platform: String) {
        viewModelScope.launch {
            getPlayerLifetimeStatsUseCase(nickname, platform)
                .onStart { _playerStats.postValue(Loading) }
                .flowOn(Dispatchers.IO)
                .catch { _playerStats.postValue(HomeFragmentState.Error(it)) }
                .collectLatest { _playerStats.postValue(Success(it)) }
        }
    }
}
