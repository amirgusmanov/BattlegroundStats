package com.example.battlegroundstats.data.sources.remote.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(@SerializedName(value = "data") val data: T)