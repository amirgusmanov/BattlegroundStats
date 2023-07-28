package com.example.battlegroundstats.domain.interactor

import android.util.Log
import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.domain.repository.PubgLocalRepository
import com.example.battlegroundstats.domain.repository.PubgRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class GetPlayerMatchesUseCase(
    private val localRepository: PubgLocalRepository,
    private val remoteRepository: PubgRemoteRepository
) : BaseUseCase<String, Flow<List<Match>>> {

    override suspend fun invoke(nickname: String, platform: String): Flow<List<Match>> =
        remoteRepository.getPlayerMatches(platform, nickname)
            .flowOn(Dispatchers.IO)
            .onEach { matches -> localRepository.addMatches(matches) }
            .catch {
                Log.i("ERROR", "Too many request probably", it)
                emit(localRepository.getMatches())
            }

}