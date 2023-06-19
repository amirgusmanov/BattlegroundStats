package com.example.battlegroundstats.data.sources.remote.api.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName(value = "data") val data: T
)