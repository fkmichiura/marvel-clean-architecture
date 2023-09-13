package com.michiura.domain.repository.entities

data class CharacterDetailsEntity(
    val name: String,
    val description: String,
    val thumbnail: ThumbnailEntity
)
