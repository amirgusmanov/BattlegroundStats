package com.example.battlegroundstats.presentation.ui.main.recentmatches

sealed interface Content {
    val type: Int

    data class MatchItem(
        override val type: Int = MATCH_TYPE,
        val mapName: String,
        val winPlace: Int,
        val damageDealt: Double,
        val kills: Int,
        val gameMode: String,
        val matchTimeCreated: String
    ) : Content

    object EmptyItem : Content {
        override val type: Int = EMPTY_TYPE
    }

    companion object {
        const val MATCH_TYPE = 11
        const val EMPTY_TYPE = 13
    }
}