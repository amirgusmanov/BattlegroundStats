package com.example.battlegroundstats.data.sources.remote.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BaseResponse<T>(@SerializedName(value = "data") val data: T)