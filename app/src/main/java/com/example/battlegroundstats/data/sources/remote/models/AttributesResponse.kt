package com.example.battlegroundstats.data.sources.remote.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PlayerStatsResponse(@SerializedName("attributes") val attributes: AttributesResponse)

@Keep
data class AttributesResponse(@SerializedName("gameModeStats") val gameModes: GameModesResponse)

@Keep
data class GameModesResponse(
    @SerializedName("duo") val duo: BaseStatsResponse,
    @SerializedName("duo-fpp") val duoFPP: BaseStatsResponse,
    @SerializedName("solo") val solo: BaseStatsResponse,
    @SerializedName("solo-fpp") val soloFPP: BaseStatsResponse,
    @SerializedName("squad") val squad: BaseStatsResponse,
    @SerializedName("squad-fpp") val squadFPP: BaseStatsResponse
)

@Keep
data class BaseStatsResponse(
    @SerializedName("kills") val kills: Int,
    @SerializedName("dBNOs") val knocked: Int,
    @SerializedName("top10s") val top10: Int,
    @SerializedName("wins") val wins: Int,
    @SerializedName("losses") val losses: Int,
    @SerializedName("damageDealt") val damageDealt: Double,
    @SerializedName("rideDistance") val drivenDistance: Double,
    @SerializedName("walkDistance") val walkedDistance: Double,
    @SerializedName("swimDistance") val swamDistance: Double,
    @SerializedName("roundMostKills") val hKillStreak: Int,
    @SerializedName("headshotKills") val headshots: Int,
    @SerializedName("assists") val assists: Int,
    @SerializedName("teamKills") val teamKills: Int,
    @SerializedName("suicides") val suicides: Int,
    @SerializedName("longestKill") val longestKill: Double,
    @SerializedName("roadKills") val roadKills: Int,
    @SerializedName("vehicleDestroys") val vehiclesDestroyed: Int,
    @SerializedName("boosts") val boosts: Int,
    @SerializedName("heals") val heals: Int,
    @SerializedName("revives") val teammatesRev: Int
)


