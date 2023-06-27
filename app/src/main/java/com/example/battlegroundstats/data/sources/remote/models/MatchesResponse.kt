package com.example.battlegroundstats.data.sources.remote.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MatchObjectResponse(
    @SerializedName("data") val data: MatchDataResponse,
    @SerializedName("included") val players: List<MatchPlayersIncluded>
) {
    val mapName: String
        get() = data.attributes.mapName

    val gameMode: String
        get() = data.attributes.gameMode

    val time: String
        get() = data.attributes.timeCreated
}

@Keep
data class MatchDataResponse(
    @SerializedName("attributes") val attributes: MatchDataAttributes
)

@Keep
data class MatchDataAttributes(
    @SerializedName("gameMode") val gameMode: String,
    @SerializedName("mapName") val mapName: String,
    @SerializedName("createdAt") val timeCreated: String
)

@Keep
data class MatchPlayersIncluded(
    @SerializedName("attributes") val playerAttributes: PlayerDataAttributes
)

@Keep
data class PlayerDataAttributes(
    @SerializedName("stats") val playerStats: PlayerMatchStats
)

@Keep
data class PlayerMatchStats(
    @SerializedName("playerId") val playerId: String,
    @SerializedName("winPlace") val winPlace: Int,
    @SerializedName("damageDealt") val damageDealt: Double,
    @SerializedName("kills") val kills: Int
)