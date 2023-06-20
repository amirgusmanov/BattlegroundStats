package com.example.battlegroundstats.data.sources.remote.mapper

import com.example.battlegroundstats.domain.models.PlayerModeType

interface ResponseMapper<in P, out R> {

    fun mapFromRemote(player: P, mode: PlayerModeType): R

}