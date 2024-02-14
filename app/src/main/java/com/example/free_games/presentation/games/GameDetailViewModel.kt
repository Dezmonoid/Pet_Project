package com.example.free_games.presentation.games

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.free_games.domain.GameRepository
import com.example.free_games.domain.model.GameDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesDetailViewModel @Inject constructor(
    private val repository: GameRepository
) : ViewModel() {
    private val _liveData = MutableLiveData<GameDetail>()
    val liveData: LiveData<GameDetail>
        get() = _liveData


    init {
        getDetail(GameDetailFragment.gameId)
    }

    private fun getDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val gameDetail = repository.getGameDetail(id)
            withContext(Dispatchers.Main) {
                _liveData.value = gameDetail
            }
        }
    }
}