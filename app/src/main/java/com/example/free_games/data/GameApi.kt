package com.example.free_games.data

import com.example.free_games.data.model.GameDetailNW
import com.example.free_games.data.model.GameNW
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("games")
    suspend fun getGamesData(
    ): List<GameNW>

    @GET("game?")
    suspend fun getGameDetail(
        @Query("id") gameId: Int,
    ): GameDetailNW

}