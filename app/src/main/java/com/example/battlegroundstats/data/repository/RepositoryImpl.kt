package com.example.battlegroundstats.data.repository

import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.repository.PubgRepository

class RepositoryImpl : PubgRepository {

    override suspend fun getPlayerLifetimeStats(): Player {
        TODO("Not yet implemented")
    }

}