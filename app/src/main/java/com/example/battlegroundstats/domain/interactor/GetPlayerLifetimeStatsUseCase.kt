package com.example.battlegroundstats.domain.interactor

import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType
import com.example.battlegroundstats.domain.repository.PubgRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.IllegalStateException

class GetPlayerLifetimeStatsUseCase(private val repository: PubgRemoteRepository) :
    BaseUseCase<String, Flow<Player>> {

    override suspend fun invoke(nickname: String, platform: String): Flow<Player> =
        repository.getPlayerLifetimeStatsFirstTime(platform, nickname, PlayerModeType.SOLO)
}