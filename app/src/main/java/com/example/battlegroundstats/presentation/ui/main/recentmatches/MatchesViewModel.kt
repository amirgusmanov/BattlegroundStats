package com.example.battlegroundstats.presentation.ui.main.recentmatches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.battlegroundstats.domain.interactor.GetPlayerMatchesUseCase
import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesState.Loading
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesState.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

sealed interface MatchesState {
    object Loading : MatchesState
    data class Success(val data: List<Match>) : MatchesState
}

class MatchesViewModel(private val getPlayerMatchesUseCase: GetPlayerMatchesUseCase) : ViewModel() {

    private var _matchesList: MutableLiveData<MatchesState> = MutableLiveData()
    val matchesList: LiveData<MatchesState>
        get() = _matchesList

    fun getMatches(nickname: String, platform: String) {
        _matchesList.postValue(Loading)
        viewModelScope.launch {
            getPlayerMatchesUseCase(nickname, platform)
                .flowOn(Dispatchers.IO)
                .collectLatest { _matchesList.postValue(Success(it)) }
        }
    }
}