package com.example.battlegroundstats.data.sources.remote.api.response

import com.example.battlegroundstats.domain.models.old.RelationShipData
import com.google.gson.annotations.SerializedName

data class PlayerResponse(@SerializedName("data") val data: List<PlayerDataResponse>) {
    val id: String
        get() = data.firstOrNull()?.id as String
}

data class PlayerDataResponse(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("relationships") val relationShips: RelationShipData
)