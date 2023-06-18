package com.example.battlegroundstats.domain.models.old

import com.example.battlegroundstats.domain.models.old.MatchData
import com.google.gson.annotations.SerializedName

data class RelationShipData(
    @SerializedName("matches") val matches: MatchData
)
