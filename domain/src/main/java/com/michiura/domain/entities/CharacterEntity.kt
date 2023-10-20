package com.michiura.domain.entities

data class CharacterEntity(
    val characterId: Int,
    val characterName: String,
    val characterThumbnail: ThumbnailEntity
)
