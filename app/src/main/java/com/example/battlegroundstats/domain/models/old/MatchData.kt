package com.example.battlegroundstats.domain.models.old

import com.example.battlegroundstats.domain.models.old.Match
import com.google.gson.annotations.SerializedName

data class MatchData(
    @SerializedName("data") val data: List<Match>
)
