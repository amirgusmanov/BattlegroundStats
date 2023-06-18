package com.example.battlegroundstats.domain.models.old

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String
)