package com.example.free_games.presentation.poe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class POEViewModel : ViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String>
        get() = _text
}