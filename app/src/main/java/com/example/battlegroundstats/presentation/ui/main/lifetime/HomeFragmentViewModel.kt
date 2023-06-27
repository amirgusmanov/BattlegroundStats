package com.example.battlegroundstats.presentation.ui.main.lifetime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.battlegroundstats.data.repository.RepositoryRemoteImpl
import com.example.battlegroundstats.domain.interactor.GetPlayerLifetimeStatsUseCase
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentState.Loading
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentState.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

sealed interface HomeFragmentState {
    object Loading : HomeFragmentState
    data class Success(val data: Flow<Player>) : HomeFragmentState
}

class HomeFragmentViewModel(
    private val getPlayerLifetimeStatsUseCase: GetPlayerLifetimeStatsUseCase
) : ViewModel() {

    private val _playerStats: MutableLiveData<HomeFragmentState> = MutableLiveData()
    val playerStats: LiveData<HomeFragmentState>
        get() = _playerStats

    fun getPlayerStats(nickname: String, platform: String) {
        _playerStats.postValue(Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val stats = getPlayerLifetimeStatsUseCase(nickname, platform)
            delay(2000)
            _playerStats.postValue(Success(stats))
        }
    }

    companion object {
        fun factory() = viewModelFactory {
            initializer {
                val useCase =
                    GetPlayerLifetimeStatsUseCase(RepositoryRemoteImpl())
                HomeFragmentViewModel(useCase)
            }
        }
    }

}
