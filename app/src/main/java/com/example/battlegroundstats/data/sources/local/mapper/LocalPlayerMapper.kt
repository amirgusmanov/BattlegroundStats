package com.example.battlegroundstats.data.sources.local.mapper

import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeSoloDataEntity
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType
import com.example.battlegroundstats.domain.models.PlayerModeType.DUO
import com.example.battlegroundstats.domain.models.PlayerModeType.SOLO
import com.example.battlegroundstats.domain.models.PlayerModeType.SQUAD

class LocalPlayerMapper : EntityMapper<PlayerLifetimeSoloDataEntity, Player> {

    override fun mapFromEntity(player: PlayerLifetimeSoloDataEntity, mode: PlayerModeType): Player =
        when (mode) {
            SOLO -> mapStatsToPlayer(player)
            DUO -> mapStatsToPlayer(player)
            SQUAD -> mapStatsToPlayer(player)
        }


    override fun mapToEntity(player: Player, mode: PlayerModeType): PlayerLifetimeSoloDataEntity =
        when (mode) {
            SOLO -> mapPlayerToSoloEntity(player)
            DUO -> mapPlayerToSoloEntity(player)
            SQUAD -> mapPlayerToSoloEntity(player)
        }

    private fun mapStatsToPlayer(player: PlayerLifetimeSoloDataEntity) = Player(
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
        teammatesRev = player.teammatesRev
    )

    private fun mapPlayerToSoloEntity(player: Player) =
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