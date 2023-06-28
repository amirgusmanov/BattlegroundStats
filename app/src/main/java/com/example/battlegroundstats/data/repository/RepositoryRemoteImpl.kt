package com.example.battlegroundstats.data.repository

import com.example.battlegroundstats.data.sources.remote.api.ApiClient
import com.example.battlegroundstats.data.sources.remote.mapper.RemoteMatchMapper
import com.example.battlegroundstats.data.sources.remote.mapper.RemotePlayerMapper
import com.example.battlegroundstats.data.sources.remote.models.MatchObjectResponse
import com.example.battlegroundstats.data.sources.remote.models.MatchResponse
import com.example.battlegroundstats.data.sources.remote.models.PlayerResponse
import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType
import com.example.battlegroundstats.domain.repository.PubgRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryRemoteImpl(
    private val playerMapper: RemotePlayerMapper = RemotePlayerMapper(),
    private val matchMapper: RemoteMatchMapper = RemoteMatchMapper()
) : PubgRemoteRepository {

    override suspend fun getPlayerLifetimeStatsFirstTime(
        platform: String,
        nickname: String,
        mode: PlayerModeType
    ): Flow<Player> = flow {
        val id = ApiClient.pubgService().searchPlayerByNickname(platform, nickname).id
        val player = ApiClient.pubgService().getPlayerStats(platform, id)
        emit(playerMapper.mapFromRemote(player, mode))
    }

    override suspend fun getPlayerMatches(platform: String, nickname: String): Flow<List<Match>> =
        flow {
            val player: PlayerResponse =
                ApiClient.pubgService().searchPlayerByNickname(platform, nickname)
            val matches: List<MatchResponse> = player.data[0].relationships.matches.data
            val recentMatches = mutableListOf<Match>()

            for (matchResponse in matches.take(1)) {
                val matchObjectResponse: MatchObjectResponse =
                    ApiClient.pubgService().getMatch(platform, matchResponse.id)
                val playerStats = matchObjectResponse.players.find {
                    it.playerAttributes.playerStats.playerId == player.data[0].id
                }
                val matchModel = playerStats?.let {
                    matchMapper.mapFromRemote(
                        matchObjectResponse,
                        it.playerAttributes.playerStats.winPlace,
                        it.playerAttributes.playerStats.kills,
                        it.playerAttributes.playerStats.damageDealt
                    )
                }
                matchModel?.let { recentMatches.add(it) }
            }
            emit(recentMatches)
        }
}