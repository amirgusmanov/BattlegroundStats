package com.example.battlegroundstats.domain.models

data class Player(
    val kills: Int,
    val knocked: Int,
    val top10: Int,
    val wins: Int,
    val losses: Int,
    val damageDealt: Double,
    val drivenDistance: Double,
    val walkedDistance: Double,
    val swamDistance: Double,
    val hKillStreak: Int,
    val headshots: Int,
    val assists: Int,
    val teamKills: Int,
    val suicides: Int,
    val longestKill: Double,
    val roadKills: Int,
    val vehiclesDestroyed: Int,
    val boosts: Int,
    val heals: Int,
    val teammatesRev: Int,
)
