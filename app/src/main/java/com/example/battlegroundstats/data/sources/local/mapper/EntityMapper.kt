package com.example.battlegroundstats.data.sources.local.mapper

import com.example.battlegroundstats.domain.models.PlayerModeType

interface EntityMapper<in P, out R> {

    fun mapFromEntity(player: P, mode: PlayerModeType): R

}