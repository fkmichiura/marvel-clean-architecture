package com.michiura.datasource.mappers

import com.michiura.datasource.network.response.CharacterWrapperResponse
import com.michiura.datasource.entities.CharacterContainerEntity
import com.michiura.datasource.entities.CharacterEntity
import com.michiura.datasource.entities.ThumbnailEntity

object CharactersDataMapper {

    fun mapCharacterWrapperResponseToEntity(
        characterWrapperResponse: CharacterWrapperResponse
    ): CharacterContainerEntity = CharacterContainerEntity(
        charactersList = characterWrapperResponse.data.results.map { characterResponse ->
            CharacterEntity(
                characterId = characterResponse.id,
                characterName = characterResponse.name,
                characterDescription = characterResponse.description,
                characterModifiedDate = characterResponse.modified,
                characterThumbnail = ThumbnailEntity(
                    thumbnailFullPath = characterResponse.thumbnail.path
                            + characterResponse.thumbnail.extension
                )
            )
        }
    )
}
