package com.example.battlegroundstats.data.repository

import com.example.battlegroundstats.data.sources.remote.api.ApiClient
import com.example.battlegroundstats.data.sources.remote.mapper.RemotePlayerMapper
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType
import com.example.battlegroundstats.domain.repository.PubgRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryRemoteImpl(private val mapper: RemotePlayerMapper) : PubgRemoteRepository {

    override suspend fun getPlayerLifetimeStatsFirstTime(
        platform: String,
        nickname: String,
        mode: PlayerModeType
    ): Flow<Player> = flow {
        val id = ApiClient.pubgService().searchPlayerByNickname(platform, nickname).id
        val player = ApiClient.pubgService().getPlayerStats(platform, id)
        emit(mapper.mapFromRemote(player, mode))
    }

}