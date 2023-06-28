package com.example.battlegroundstats.data.repository

import com.example.battlegroundstats.data.sources.local.db.AppDatabase
import com.example.battlegroundstats.data.sources.local.mapper.LocalMatchMapper
import com.example.battlegroundstats.data.sources.local.mapper.LocalPlayerMapper
import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.domain.repository.PubgLocalRepository

class RepositoryLocalImpl(
    private val db: AppDatabase,
    private val playerMapper: LocalPlayerMapper = LocalPlayerMapper(),
    private val matchMapper: LocalMatchMapper = LocalMatchMapper()
) : PubgLocalRepository {

    override suspend fun addPlayer(player: Player): Boolean {
        db.playerLifetimeDataDao()
            .insertPlayerSolo(playerMapper.mapToEntity(player))
        return true
    }

    override suspend fun addMatches(matches: List<Match>): Boolean {
        val result = matches
            .map { match -> matchMapper.mapToEntity(match) }
            .let { entityList -> db.matchDao().insertMatch(*entityList.toTypedArray()) }
        return result.isNotEmpty()
    }

    override suspend fun getMatches(): List<Match> =
        db.matchDao().getMatches().map { match -> matchMapper.mapFromEntity(match) }
}