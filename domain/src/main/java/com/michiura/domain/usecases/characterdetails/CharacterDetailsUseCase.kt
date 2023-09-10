package com.michiura.domain.usecases.characterdetails

import com.michiura.datasource.repository.MarvelRepository
import com.michiura.datasource.repository.states.Result

class CharacterDetailsUseCase(
    private val repository: MarvelRepository
) {
     suspend operator fun invoke(characterId: Int): Result =
         repository.fetchCharacterDetails(characterId = characterId)
}
