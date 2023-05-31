package com.michiura.datasource.mappers

import com.michiura.datasource.network.response.CharacterWrapperResponse
import com.michiura.domain.entities.CharacterContainerEntity
import com.michiura.domain.entities.CharacterEntity
import com.michiura.domain.entities.ThumbnailEntity

class CharactersDataMapper {

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
