package com.example.battlegroundstats.domain.models.old

import com.google.gson.annotations.SerializedName

data class PlayerStats(
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "assists") val assists: Int,
    @SerializedName(value = "boosts") val boosts: Int,
    @SerializedName(value = "dBNOs") val enemyKnocked: Int,
    @SerializedName(value = "kills") val kills: Int
)
