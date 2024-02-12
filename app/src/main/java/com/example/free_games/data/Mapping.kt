package com.example.free_games.data

import com.example.free_games.data.model.GameNW
import com.example.free_games.domain.model.Game

fun GameNW.toDomain(): Game =
    Game(
        id = id ?: 0,
        name = title.toString(),
        image = thumbnail.toString(),
        developer = developer.toString(),
        freeToGameUrl = freetogameProfileUrl.toString(),
        gameUrl = gameUrl.toString(),
        type = genre.toString(),
        platform = platform.toString(),
        publisher = publisher.toString(),
        releaseDate = releaseDate.toString(),
        shortDescription = shortDescription.toString()
    )