package com.example.battlegroundstats.domain.repository

import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType
import kotlinx.coroutines.flow.Flow

interface PubgRemoteRepository {

    suspend fun getPlayerLifetimeStatsFirstTime(
        platform: String,
        nickname: String,
        mode: PlayerModeType
    ): Flow<Player>

}