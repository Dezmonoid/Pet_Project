package com.example.free_games.presentation.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.free_games.domain.model.Game
import com.example.free_games.domain.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val repository: GameRepository
) : ViewModel() {

    private val _liveData = MutableLiveData<List<Game>>()
    val liveData: LiveData<List<Game>>
        get() = _liveData


    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val gamesList = repository.getGames()
            withContext(Dispatchers.Main){
                _liveData.value = gamesList
            }
        }
    }
}