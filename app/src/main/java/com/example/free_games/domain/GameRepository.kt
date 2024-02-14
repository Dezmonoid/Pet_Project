package com.example.free_games.domain

import com.example.free_games.domain.model.Game
import com.example.free_games.domain.model.GameDetail

interface GameRepository {
    suspend fun getGames(): List<Game>
    suspend fun getGameDetail(id:Int): GameDetail
}