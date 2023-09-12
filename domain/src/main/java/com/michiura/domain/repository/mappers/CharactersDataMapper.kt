package com.michiura.domain.repository.mappers

import com.michiura.datasource.network.response.CharacterWrapperResponse
import com.michiura.domain.repository.entities.CharacterEntity
import com.michiura.domain.repository.entities.ThumbnailEntity

object CharactersDataMapper {
    fun mapCharacterWrapperResponseToCharactersListEntity(
        characterWrapperResponse: CharacterWrapperResponse
    ): List<CharacterEntity> = characterWrapperResponse.data.results.map { characterResponse ->
        CharacterEntity(
            characterId = characterResponse.id,
            characterName = characterResponse.name,
            characterDescription = characterResponse.description,
            characterModifiedDate = characterResponse.modified,
            characterThumbnail = ThumbnailEntity(
                thumbnailFullPath = characterResponse.thumbnail.path + characterResponse.thumbnail.extension
            )
        )
    }.toList()

    fun mapCharacterWrapperResponseToCharacterEntity(
        characterWrapperResponse: CharacterWrapperResponse
    ): CharacterEntity = characterWrapperResponse.data.results.map { characterResponse ->
        CharacterEntity(
            characterId = characterResponse.id,
            characterName = characterResponse.name,
            characterDescription = characterResponse.description,
            characterModifiedDate = characterResponse.modified,
            characterThumbnail = ThumbnailEntity(
                thumbnailFullPath = characterResponse.thumbnail.path + characterResponse.thumbnail.extension
            )
        )
    }.first()
}
