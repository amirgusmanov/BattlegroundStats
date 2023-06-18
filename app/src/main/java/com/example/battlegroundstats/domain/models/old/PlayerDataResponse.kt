package com.example.battlegroundstats.domain.models.old

import com.google.gson.annotations.SerializedName

data class PlayerDataResponse(@SerializedName("data") val data: List<PlayerData>) {
    val id: String
        get() = data.firstOrNull()?.id as String
}