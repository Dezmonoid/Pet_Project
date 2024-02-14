package com.example.free_games.domain.model

import com.google.gson.annotations.SerializedName

data class GameDetail(
    val id: Int,
    val description: String,
    val developer: String,
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val screenshots: List<Screenshot>,
    val status: String,
    val thumbnail: String,
    val title: String,
    val graphics: String,
    val memory: String,
    val os: String,
    val processor: String,
    val storage: String
) {
    data class Screenshot(
        val id: Int,
        val image: String
    )
}