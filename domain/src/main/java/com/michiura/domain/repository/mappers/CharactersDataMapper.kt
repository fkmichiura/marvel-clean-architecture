package com.michiura.domain.repository.mappers

import com.michiura.datasource.network.response.CharacterWrapperResponse
import com.michiura.domain.repository.entities.CharacterDetailsEntity
import com.michiura.domain.repository.entities.CharacterEntity
import com.michiura.domain.repository.entities.ThumbnailEntity

object CharactersDataMapper {
    fun mapCharacterWrapperResponseToCharactersListEntity(
        characterWrapperResponse: CharacterWrapperResponse
    ): List<CharacterEntity> = characterWrapperResponse.data.results.map { characterResponse ->
        CharacterEntity(
            characterId = characterResponse.id,
            characterName = characterResponse.name,
            characterThumbnail = ThumbnailEntity(
                thumbnailFullPath = "${characterResponse.thumbnail.path}.${characterResponse.thumbnail.extension}"
            )
        )
    }.toList()

    fun mapCharacterWrapperResponseToCharacterEntity(
        characterWrapperResponse: CharacterWrapperResponse
    ): CharacterDetailsEntity = characterWrapperResponse.data.results.map { characterResponse ->
        CharacterDetailsEntity(
            name = characterResponse.name,
            description = characterResponse.description,
            thumbnail = ThumbnailEntity(
                thumbnailFullPath = "${characterResponse.thumbnail.path}.${characterResponse.thumbnail.extension}"
            )
        )
    }.first()
}
