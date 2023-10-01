package com.example.battlegroundstats.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserFields(val nickname: String?, val platform: String?) : Parcelable