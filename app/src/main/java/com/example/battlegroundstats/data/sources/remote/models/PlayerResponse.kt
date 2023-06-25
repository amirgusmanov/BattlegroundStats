package com.example.battlegroundstats.data.sources.remote.models

import com.google.gson.annotations.SerializedName

data class PlayerResponse(@SerializedName("data") val data: List<PlayerDataResponse>) {
    val id: String
        get() = data.firstOrNull()?.id as String
}

data class PlayerDataResponse(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("relationships") val relationships: List<RelationResponse>
)

data class RelationResponse(
    @SerializedName("matches") val matches: MatchesResponse
)

data class MatchesResponse(
    @SerializedName("data") val data: List<String>
)