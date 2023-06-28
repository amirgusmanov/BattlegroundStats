package com.example.battlegroundstats.domain.repository

import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.domain.models.Player

interface PubgLocalRepository {

    suspend fun addPlayer(player: Player): Boolean

    suspend fun addMatches(matches: List<Match>): Boolean

    suspend fun getMatches(): List<Match>
}