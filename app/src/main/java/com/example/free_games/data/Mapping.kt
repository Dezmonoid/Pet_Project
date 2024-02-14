package com.example.free_games.data

import com.example.free_games.data.model.GameDetailNW
import com.example.free_games.data.model.GameNW
import com.example.free_games.domain.model.Game
import com.example.free_games.domain.model.GameDetail

fun GameNW.toDomain(): Game =
    Game(
        id = id.toZeroIfNull(),
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

fun GameDetailNW.toDomain(): GameDetail =
    GameDetail(
        id = id.toZeroIfNull(),
        description = description.toString(),
        developer = developer.toString(),
        gameUrl = gameUrl.toString(),
        genre = genre.toString(),
        platform = platform.toString(),
        publisher = publisher.toString(),
        releaseDate = releaseDate.toString(),
        screenshots = screenshots?.map { it.toDomain() }.orEmpty(),
        status = status.toString(),
        thumbnail = thumbnail.toString(),
        title = title.toString(),
        graphics = minimumSystemRequirements?.graphics.toString(),
        memory = minimumSystemRequirements?.memory.toString(),
        os = minimumSystemRequirements?.os.toString(),
        processor = minimumSystemRequirements?.processor.toString(),
        storage = minimumSystemRequirements?.storage.toString()
    )

fun GameDetailNW.Screenshot?.toDomain(): GameDetail.Screenshot =
    GameDetail.Screenshot(
        id = this?.id.toZeroIfNull(),
        image = this?.image.toString()
    )

fun Int?.toZeroIfNull(): Int = this ?: 0