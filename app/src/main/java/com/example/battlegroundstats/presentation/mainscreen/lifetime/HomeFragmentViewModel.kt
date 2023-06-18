package com.example.battlegroundstats.presentation.mainscreen.lifetime

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.battlegroundstats.data.sources.remote.api.ApiClient
import com.example.battlegroundstats.data.sources.remote.service.PUBGApiService
import com.example.battlegroundstats.domain.models.old.PlayerDataResponse
import com.example.battlegroundstats.domain.models.old.PlayerStats
import com.example.battlegroundstats.presentation.mainscreen.lifetime.HomeFragmentViewModelStatus.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

enum class HomeFragmentViewModelStatus { LOADING, ERROR, DONE }

//time solution for test
class HomeFragmentViewModel(private val pubgApiService: PUBGApiService) : ViewModel() {

    private val _status: MutableLiveData<HomeFragmentViewModelStatus> = MutableLiveData()
    val status: LiveData<HomeFragmentViewModelStatus>
        get() = _status

    private val _player: MutableLiveData<PlayerDataResponse> = MutableLiveData()
    val player: LiveData<PlayerDataResponse>
        get() = _player

    private val _playerLifetime: MutableLiveData<PlayerStats> = MutableLiveData()
    val playerLifetime: LiveData<PlayerStats>
        get() = _playerLifetime

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    fun searchPlayerByNickname(platform: String, nickname: String) {
        viewModelScope.launch {
            _status.value = LOADING
            withContext(Dispatchers.IO) {
                try {
                    val searchedPlayer: PlayerDataResponse = pubgApiService.searchPlayerByNickname(
                        platform,
                        nickname
                    )
                    val playerLifetimeStats: PlayerStats = pubgApiService.getPlayerStats(
                        platform,
                        searchedPlayer.id
                    )
                    _playerLifetime.postValue(playerLifetimeStats)
                    _player.postValue(searchedPlayer)
                    _status.postValue(DONE)
                    Log.d("PLAYER ID", "Searched player: ${searchedPlayer.id}")
                    Log.d("PLAYER STATS", "SEARCHED PLAYER: $playerLifetimeStats")
                    Log.d("PLAYER MATCHES ID", "MATCHES: ${searchedPlayer.data[0].relationShips.matches.data}")
                } catch (e: Exception) {
                    _status.postValue(ERROR)
                    _error.postValue(e.message)
                    Log.d("EXCEPTION IN SEARCHING", "${e.message}")
                }
            }
        }
    }

    companion object {
        fun factory() = viewModelFactory {
            initializer {
                HomeFragmentViewModel(pubgApiService = ApiClient.pubgService())
            }
        }
    }

}