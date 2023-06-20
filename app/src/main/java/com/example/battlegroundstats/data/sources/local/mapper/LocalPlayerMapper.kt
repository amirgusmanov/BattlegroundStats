package com.example.battlegroundstats.data.sources.local.mapper

import com.example.battlegroundstats.data.sources.local.models.DataEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeSoloDataEntity
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType

class LocalPlayerMapper : EntityMapper<DataEntity, Player> {

    override fun mapFromEntity(player: DataEntity, mode: PlayerModeType): Player {
        TODO()
    }

    override fun mapToEntity(player: Player, mode: PlayerModeType): DataEntity =
        when (mode) {
            PlayerModeType.SOLO -> TODO()
            PlayerModeType.DUO -> TODO()
            PlayerModeType.SQUAD -> TODO()
        }

    private fun mapStatsToPlayer() {

    }

    //the same method i need to do for duo and squad entity = boilerplate
    private fun mapPlayerToSoloEntity(player: Player, mode: PlayerModeType) =
        PlayerLifetimeSoloDataEntity(
            kills = player.kills,
            knocked = player.knocked,
            top10 = player.top10,
            wins = player.wins,
            losses = player.losses,
            damageDealt = player.damageDealt,
            drivenDistance = player.drivenDistance,
            walkedDistance = player.walkedDistance,
            swamDistance = player.swamDistance,
            hKillStreak = player.hKillStreak,
            headshots = player.headshots,
            assists = player.assists,
            teamKills = player.teamKills,
            suicides = player.suicides,
            longestKill = player.longestKill,
            roadKills = player.roadKills,
            vehiclesDestroyed = player.vehiclesDestroyed,
            boosts = player.boosts,
            heals = player.heals,
            teammatesRev = player.teammatesRev,
            enemiesKnockedOut = player.knocked
        )

}