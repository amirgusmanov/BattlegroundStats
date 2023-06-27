package com.example.battlegroundstats.data.sources.local.models

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "match")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("map_name") val mapName: String,
    @ColumnInfo("win_place") val winPlace: Int,
    @ColumnInfo("damageDealt") val damageDealt: Double,
    @ColumnInfo("kills") val kills: Int,
    @ColumnInfo("game_mode") val gameMode: String,
    @ColumnInfo("match_time_created") val matchTimeCreated: String
) {
    constructor(
        mapName: String,
        winPlace: Int,
        damageDealt: Double,
        kills: Int,
        gameMode: String,
        matchTimeCreated: String
    ) : this(
        id = 0,
        mapName = mapName,
        winPlace = winPlace,
        damageDealt = damageDealt,
        kills = kills,
        gameMode = gameMode,
        matchTimeCreated = matchTimeCreated
    )
}