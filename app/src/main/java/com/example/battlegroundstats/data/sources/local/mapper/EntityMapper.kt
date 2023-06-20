package com.example.battlegroundstats.data.sources.local.mapper

import com.example.battlegroundstats.domain.models.PlayerModeType

interface EntityMapper<P, R> {

    fun mapFromEntity(player: P, mode: PlayerModeType): R

    fun mapToEntity(player: R, mode: PlayerModeType): P

}