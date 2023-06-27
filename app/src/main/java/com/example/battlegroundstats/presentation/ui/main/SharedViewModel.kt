package com.example.battlegroundstats.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String>
        get() = _nickname

    private val _platform = MutableLiveData<String>()
    val platform: LiveData<String>
        get() = _platform

    fun setNickname(nickname: String) {
        _nickname.value = nickname
    }

    fun setPlatform(platform: String) {
        _platform.value = platform
    }

}