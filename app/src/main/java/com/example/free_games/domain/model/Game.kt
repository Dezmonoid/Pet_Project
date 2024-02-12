package com.example.free_games.domain.model

import com.google.gson.annotations.SerializedName

data class Game(
    val id: Int,
    val name: String,
    val image: String,
    val developer: String,
    val freeToGameUrl: String,
    val gameUrl: String,
    val type: String,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val shortDescription: String
)