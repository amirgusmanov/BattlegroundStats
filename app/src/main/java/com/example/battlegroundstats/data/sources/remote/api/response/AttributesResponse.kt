package com.example.battlegroundstats.data.sources.remote.api.response

import com.google.gson.annotations.SerializedName

data class PlayerStatsResponse(
    @SerializedName("attributes") val attributes: AttributesResponse
){
    val duoStats: DuoResponse
        get() = attributes.gameModes.duo
}

data class AttributesResponse(
    @SerializedName("gameModeStats") val gameModes: GameModesResponse
)

data class GameModesResponse(
    @SerializedName("duo") val duo: DuoResponse
)

data class DuoResponse(
    @SerializedName("kills") val kills: Int,
    @SerializedName("losses") val losses: Int
)