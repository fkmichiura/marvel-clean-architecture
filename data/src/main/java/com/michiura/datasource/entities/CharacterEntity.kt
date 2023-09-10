package com.michiura.datasource.entities

import java.util.Date

data class CharacterEntity(
    val characterId: Int,
    val characterName: String,
    val characterDescription: String,
    val characterModifiedDate: Date,
    val characterThumbnail: ThumbnailEntity
)
