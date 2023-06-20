package com.example.battlegroundstats.domain.repository

import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.models.PlayerModeType

interface PubgLocalRepository {

    suspend fun addPlayer(player: Player, mode: PlayerModeType): Boolean

}