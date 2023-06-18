package com.example.battlegroundstats.domain.models.old

import com.google.gson.annotations.SerializedName

data class PlayerData(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("relationships") val relationShips: RelationShipData
)