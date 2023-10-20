package com.michiura.domain.usecase.characterslist

import com.michiura.datasource.repository.MarvelRepository
import com.michiura.domain.entities.CharacterEntity
import com.michiura.domain.mappers.CharactersDataMapper
import com.michiura.domain.states.Result

class CharactersListUseCase(private val repository: MarvelRepository) {
    suspend operator fun invoke(): Result<List<CharacterEntity>> =
        try {
            Result.Success(
                CharactersDataMapper.mapCharacterWrapperResponseToCharactersListEntity(
                    characterWrapperResponse = repository.fetchCharactersList()
                )
            )
        } catch (e: Exception) {
            Result.Error(exception = e)
        }
}
