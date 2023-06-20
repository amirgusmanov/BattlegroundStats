package com.example.battlegroundstats.data.sources.local.mapper

import com.example.battlegroundstats.data.sources.local.models.DataEntity
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType

class LocalPlayerMapper : EntityMapper<DataEntity, Player> {

    override fun mapFromEntity(player: DataEntity, mode: PlayerModeType): Player {
        TODO()
    }

    private fun mapStatsToPlayer() {

    }

}