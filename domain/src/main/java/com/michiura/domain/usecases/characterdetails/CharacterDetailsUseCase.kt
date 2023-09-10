package com.michiura.domain.usecases.characterdetails

import com.michiura.datasource.repository.MarvelRepository
import com.michiura.datasource.repository.states.Result
import com.michiura.domain.entities.CharacterContainerEntity
import com.michiura.domain.mappers.CharactersDataMapper
import com.michiura.domain.states.MarvelResult

class CharacterDetailsUseCase(
    private val repository: MarvelRepository
) {

     suspend operator fun invoke(characterId: Int): CharacterContainerEntity {
        val state: Result = repository.fetchCharacterDetails(characterId = characterId)

        return CharactersDataMapper().mapCharacterWrapperResponseToEntity(
            characterWrapperResponse = state.response
        )
    }
}
