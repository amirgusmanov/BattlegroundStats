package com.example.battlegroundstats.domain.repository

import com.example.battlegroundstats.domain.models.Player

interface PubgRepository {

    suspend fun getPlayerLifetimeStats(): Player

}