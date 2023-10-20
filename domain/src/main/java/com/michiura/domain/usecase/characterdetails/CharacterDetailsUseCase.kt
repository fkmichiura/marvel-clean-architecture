package com.michiura.domain.usecase.characterdetails

import com.michiura.datasource.repository.MarvelRepository
import com.michiura.domain.entities.CharacterDetailsEntity
import com.michiura.domain.mappers.CharactersDataMapper
import com.michiura.domain.states.Result

class CharacterDetailsUseCase(private val repository: MarvelRepository) {
    suspend operator fun invoke(characterId: Int): Result<CharacterDetailsEntity> =
        try {
            Result.Success(
                CharactersDataMapper.mapCharacterWrapperResponseToCharacterEntity(
                    characterWrapperResponse = repository.fetchCharacterDetails(
                        characterId = characterId
                    )
                )
            )
        } catch (e: Exception) {
            Result.Error(exception = e)
        }
}
