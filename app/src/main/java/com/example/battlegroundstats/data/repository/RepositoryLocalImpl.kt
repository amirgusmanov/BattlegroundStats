package com.example.battlegroundstats.data.repository

import android.content.Context
import com.example.battlegroundstats.data.sources.local.db.AppDatabase
import com.example.battlegroundstats.data.sources.local.mapper.LocalMatchMapper
import com.example.battlegroundstats.data.sources.local.mapper.LocalPlayerMapper
import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.repository.PubgLocalRepository

class RepositoryLocalImpl(
    private val context: Context,
    private val playerMapper: LocalPlayerMapper = LocalPlayerMapper(),
    private val matchMapper: LocalMatchMapper = LocalMatchMapper()
) : PubgLocalRepository {

    override suspend fun addPlayer(player: Player): Boolean {
        AppDatabase.getDatabase(context).playerLifetimeDataDao()
            .insertPlayerSolo(playerMapper.mapToEntity(player))
        return true
    }

    override suspend fun addMatches(matches: List<Match>): Boolean {
        for (match in matches) {
            AppDatabase.getDatabase(context).matchDao().insertMatch(matchMapper.mapToEntity(match))
        }
        return true
    }

    override suspend fun getMatches(): List<Match> {
        val matches = AppDatabase.getDatabase(context).matchDao().getMatches()
        val recentMatches = mutableListOf<Match>()
        for (match in matches) {
            recentMatches.add(matchMapper.mapFromEntity(match))
        }
        return recentMatches
    }

    override suspend fun clearMatches() =
        AppDatabase.getDatabase(context).matchDao().clearMatches()


}