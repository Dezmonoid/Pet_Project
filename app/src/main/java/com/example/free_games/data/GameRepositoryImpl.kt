package com.example.free_games.data

import com.example.free_games.domain.model.Game
import com.example.free_games.domain.GameRepository
import com.example.free_games.domain.model.GameDetail

class GameRepositoryImpl(
    private val gameApi: GameApi
) : GameRepository {
    override suspend fun getGames(): List<Game> {
        val gamesList = gameApi.getGamesData()
        return gamesList.map { it.toDomain() }
    }

    override suspend fun getGameDetail(): GameDetail {
        TODO("Not yet implemented")
    }
}