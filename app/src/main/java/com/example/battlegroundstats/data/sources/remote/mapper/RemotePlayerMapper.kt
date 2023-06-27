package com.example.battlegroundstats.data.sources.remote.mapper

import com.example.battlegroundstats.data.sources.remote.models.BaseResponse
import com.example.battlegroundstats.data.sources.remote.models.BaseStatsResponse
import com.example.battlegroundstats.data.sources.remote.models.PlayerStatsResponse
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType

class RemotePlayerMapper : ResponseMapper<BaseResponse<PlayerStatsResponse>, Player> {

    override fun mapFromRemote(
        player: BaseResponse<PlayerStatsResponse>,
        mode: PlayerModeType
    ): Player {
        val statsResponse = player.data.attributes.gameModes
        val baseStats = when (mode) {
            PlayerModeType.SOLO -> statsResponse.soloFPP
            PlayerModeType.DUO -> statsResponse.duoFPP
            PlayerModeType.SQUAD -> statsResponse.squadFPP
        }
        return mapBaseStatsToPlayer(baseStats)
    }

    private fun mapBaseStatsToPlayer(baseStats: BaseStatsResponse): Player = Player(
        kills = baseStats.kills,
        knocked = baseStats.knocked,
        top10 = baseStats.top10,
        wins = baseStats.wins,
        losses = baseStats.losses,
        damageDealt = baseStats.damageDealt,
        drivenDistance = baseStats.drivenDistance,
        walkedDistance = baseStats.walkedDistance,
        swamDistance = baseStats.swamDistance,
        hKillStreak = baseStats.hKillStreak,
        headshots = baseStats.headshots,
        assists = baseStats.assists,
        teamKills = baseStats.teamKills,
        suicides = baseStats.suicides,
        longestKill = baseStats.longestKill,
        roadKills = baseStats.roadKills,
        vehiclesDestroyed = baseStats.vehiclesDestroyed,
        boosts = baseStats.boosts,
        heals = baseStats.heals,
        teammatesRev = baseStats.teammatesRev
    )

}