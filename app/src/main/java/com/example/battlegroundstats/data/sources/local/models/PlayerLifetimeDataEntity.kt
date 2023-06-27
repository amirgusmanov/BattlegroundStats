package com.example.battlegroundstats.data.sources.local.models

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

open class DataEntity

@Keep
@Entity(tableName = "player_lifetime")
data class PlayerLifetimeDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("kills") val kills: Int,
    @ColumnInfo("dBNOs") val knocked: Int,
    @ColumnInfo("deaths") val deaths: Int,
    @ColumnInfo("top_10s") val top10: Int,
    @ColumnInfo("wins") val wins: Int,
    @ColumnInfo("losses") val losses: Int,
    @ColumnInfo("damage_given") val damageDealt: Double,
    @ColumnInfo("ride_distance") val drivenDistance: Double,
    @ColumnInfo("walked_distance") val walkedDistance: Double,
    @ColumnInfo("swam_distance") val swamDistance: Double,
    @ColumnInfo("highest_killstreak") val hKillStreak: Int,
    @ColumnInfo("headshots") val headshots: Int,
    @ColumnInfo("assists") val assists: Int,
    @ColumnInfo("teamkills") val teamKills: Int,
    @ColumnInfo("suicides") val suicides: Int,
    @ColumnInfo("longest_kill") val longestKill: Int,
    @ColumnInfo("roadkills") val roadKills: Int,
    @ColumnInfo("vehicles_destroyed") val vehiclesDestroyed: Int,
    @ColumnInfo("enemies_knocked_out") val enemiesKnockedOut: Int,
    @ColumnInfo("boosts") val boosts: Int,
    @ColumnInfo("heals") val heals: Int,
    @ColumnInfo("teammates_revived") val teammatesRev: Int,
) : DataEntity()

@Keep
@Entity(tableName = "player_lifetime_solo")
data class PlayerLifetimeSoloDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("kills") val kills: Int,
    @ColumnInfo("dBNOs") val knocked: Int,
    @ColumnInfo("top_10s") val top10: Int,
    @ColumnInfo("wins") val wins: Int,
    @ColumnInfo("losses") val losses: Int,
    @ColumnInfo("damage_given") val damageDealt: Double,
    @ColumnInfo("ride_distance") val drivenDistance: Double,
    @ColumnInfo("walked_distance") val walkedDistance: Double,
    @ColumnInfo("swam_distance") val swamDistance: Double,
    @ColumnInfo("highest_killstreak") val hKillStreak: Int,
    @ColumnInfo("headshots") val headshots: Int,
    @ColumnInfo("assists") val assists: Int,
    @ColumnInfo("teamkills") val teamKills: Int,
    @ColumnInfo("suicides") val suicides: Int,
    @ColumnInfo("longest_kill") val longestKill: Double,
    @ColumnInfo("roadkills") val roadKills: Int,
    @ColumnInfo("vehicles_destroyed") val vehiclesDestroyed: Int,
    @ColumnInfo("enemies_knocked_out") val enemiesKnockedOut: Int,
    @ColumnInfo("boosts") val boosts: Int,
    @ColumnInfo("heals") val heals: Int,
    @ColumnInfo("teammates_revived") val teammatesRev: Int,
) : DataEntity()

@Keep
@Entity(tableName = "player_lifetime_duo")
data class PlayerLifetimeDuoDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("kills") val kills: Int,
    @ColumnInfo("dBNOs") val knocked: Int,
    @ColumnInfo("deaths") val deaths: Int,
    @ColumnInfo("top_10s") val top10: Int,
    @ColumnInfo("wins") val wins: Int,
    @ColumnInfo("losses") val losses: Int,
    @ColumnInfo("damage_given") val damageDealt: Double,
    @ColumnInfo("ride_distance") val drivenDistance: Double,
    @ColumnInfo("walked_distance") val walkedDistance: Double,
    @ColumnInfo("swam_distance") val swamDistance: Double,
    @ColumnInfo("highest_killstreak") val hKillStreak: Int,
    @ColumnInfo("headshots") val headshots: Int,
    @ColumnInfo("assists") val assists: Int,
    @ColumnInfo("teamkills") val teamKills: Int,
    @ColumnInfo("suicides") val suicides: Int,
    @ColumnInfo("longest_kill") val longestKill: Int,
    @ColumnInfo("roadkills") val roadKills: Int,
    @ColumnInfo("vehicles_destroyed") val vehiclesDestroyed: Int,
    @ColumnInfo("enemies_knocked_out") val enemiesKnockedOut: Int,
    @ColumnInfo("boosts") val boosts: Int,
    @ColumnInfo("heals") val heals: Int,
    @ColumnInfo("teammates_revived") val teammatesRev: Int,
) : DataEntity()

@Keep
@Entity(tableName = "player_lifetime_squad")
data class PlayerLifetimeSquadDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("kills") val kills: Int,
    @ColumnInfo("dBNOs") val knocked: Int,
    @ColumnInfo("deaths") val deaths: Int,
    @ColumnInfo("top_10s") val top10: Int,
    @ColumnInfo("wins") val wins: Int,
    @ColumnInfo("losses") val losses: Int,
    @ColumnInfo("damage_given") val damageDealt: Double,
    @ColumnInfo("ride_distance") val drivenDistance: Double,
    @ColumnInfo("walked_distance") val walkedDistance: Double,
    @ColumnInfo("swam_distance") val swamDistance: Double,
    @ColumnInfo("highest_killstreak") val hKillStreak: Int,
    @ColumnInfo("headshots") val headshots: Int,
    @ColumnInfo("assists") val assists: Int,
    @ColumnInfo("teamkills") val teamKills: Int,
    @ColumnInfo("suicides") val suicides: Int,
    @ColumnInfo("longest_kill") val longestKill: Int,
    @ColumnInfo("roadkills") val roadKills: Int,
    @ColumnInfo("vehicles_destroyed") val vehiclesDestroyed: Int,
    @ColumnInfo("enemies_knocked_out") val enemiesKnockedOut: Int,
    @ColumnInfo("boosts") val boosts: Int,
    @ColumnInfo("heals") val heals: Int,
    @ColumnInfo("teammates_revived") val teammatesRev: Int,
) : DataEntity()