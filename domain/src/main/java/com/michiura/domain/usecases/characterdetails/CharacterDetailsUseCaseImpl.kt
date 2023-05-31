package com.michiura.domain.usecases.characterdetails

import com.michiura.datasource.mappers.CharactersDataMapper
import com.michiura.datasource.repository.states.RepositoryState
import com.michiura.domain.entities.CharacterContainerEntity
import com.michiura.domain.repository.MarvelRepository
import com.michiura.domain.states.MarvelResult

class CharacterDetailsUseCaseImpl(
    private val repository: MarvelRepository
) : CharacterDetailsUseCase {

    override suspend fun fetchCharacterDetails(characterId: Int): Result<CharacterContainerEntity> {
        val state: RepositoryState = repository.fetchCharacterDetails(characterId = characterId)

        when (state) {
            is RepositoryState.ResponseSuccess -> {
                MarvelResult.ResponseSuccess(
                    entity = CharactersDataMapper().mapCharacterWrapperResponseToEntity(
                        characterWrapperResponse = state.response
                    )
                )
            }

            is RepositoryState.ResponseError ->
                MarvelResult.ResponseError(errorMessage = state.errorMessage)
        }

        //TODO: Must return default value
    }
}
