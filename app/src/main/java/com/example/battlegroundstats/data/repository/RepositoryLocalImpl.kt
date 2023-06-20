package com.example.battlegroundstats.data.repository

import android.content.Context
import com.example.battlegroundstats.data.sources.local.mapper.LocalPlayerMapper
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType
import com.example.battlegroundstats.domain.repository.PubgLocalRepository

class RepositoryLocalImpl(
    private val context: Context,
    private val mapper: LocalPlayerMapper
) : PubgLocalRepository {

    override suspend fun addPlayer(player: Player, mode: PlayerModeType): Boolean {
        TODO()
    }

}