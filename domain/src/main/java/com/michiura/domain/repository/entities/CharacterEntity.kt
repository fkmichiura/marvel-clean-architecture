package com.michiura.domain.repository.entities

data class CharacterEntity(
    val characterId: Int,
    val characterName: String,
    val characterThumbnail: ThumbnailEntity
)
