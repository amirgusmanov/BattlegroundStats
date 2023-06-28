package com.example.battlegroundstats.data.sources.remote.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PlayerResponse(
    @SerializedName("data") val data: List<PlayerDataResponse>
) {
    val id: String
        get() = data.firstOrNull()?.id as String
}

@Keep
data class PlayerDataResponse(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("relationships") val relationships: RelationResponse
)

@Keep
data class RelationshipData<T>(
    @SerializedName("data") val data: T
)

@Keep
data class RelationResponse(
    @SerializedName("matches") val matches: RelationshipData<List<MatchResponse>>
)

@Keep
data class MatchResponse(
    @SerializedName("id") val id: String
)