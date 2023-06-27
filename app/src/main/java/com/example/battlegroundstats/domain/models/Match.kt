package com.example.battlegroundstats.domain.models

data class Match(
    val mapName: String,
    val winPlace: Int,
    val damageDealt: Double,
    val kills: Int,
    val gameMode: String,
    val matchTimeCreated: String
)
