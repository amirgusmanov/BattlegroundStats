package com.example.battlegroundstats.domain.interactor

import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.domain.repository.PubgLocalRepository
import com.example.battlegroundstats.domain.repository.PubgRemoteRepository
import kotlinx.coroutines.flow.Flow

class GetPlayerMatchesUseCase(
    private val localRepository: PubgLocalRepository,
    private val remoteRepository: PubgRemoteRepository
) : BaseUseCase<String, List<Match>> {

    override suspend fun invoke(nickname: String, platform: String): List<Match> {
        localRepository.clearMatches()

        val flow: Flow<List<Match>> = remoteRepository.getPlayerMatches(platform, nickname)
        var remoteMatches: List<Match> = mutableListOf()
        flow.collect { remoteMatches = it }

        val existingMatches = localRepository.getMatches()
        val newMatches = remoteMatches.filter { remoteMatch ->
            existingMatches.none {
                it.matchTimeCreated == remoteMatch.matchTimeCreated
            }
        }

        localRepository.addMatches(newMatches)
        return localRepository.getMatches()
    }

}