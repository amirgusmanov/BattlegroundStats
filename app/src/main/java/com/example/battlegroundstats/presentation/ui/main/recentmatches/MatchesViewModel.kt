package com.example.battlegroundstats.presentation.ui.main.recentmatches

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.battlegroundstats.data.repository.RepositoryLocalImpl
import com.example.battlegroundstats.data.repository.RepositoryRemoteImpl
import com.example.battlegroundstats.domain.interactor.GetPlayerMatchesUseCase
import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesState.Loading
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesState.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

sealed interface MatchesState {
    object Loading: MatchesState
    data class Success(val data: List<Match>): MatchesState
}

class MatchesViewModel(private val getPlayerMatchesUseCase: GetPlayerMatchesUseCase) : ViewModel() {

    private var _matchesList: MutableLiveData<MatchesState> = MutableLiveData()
    val matchesList: LiveData<MatchesState>
        get() = _matchesList

    fun getMatches(nickname: String, platform: String) {
        _matchesList.postValue(Loading)
        viewModelScope.launch(Dispatchers.IO) {
            getPlayerMatchesUseCase(nickname, platform).let {
                _matchesList.postValue(Success(it))
            }
        }
    }

    companion object {
        fun factory(context: Context) = viewModelFactory {
            initializer {
                MatchesViewModel(
                    GetPlayerMatchesUseCase(
                        RepositoryLocalImpl(context),
                        RepositoryRemoteImpl()
                    )
                )
            }
        }
    }

}