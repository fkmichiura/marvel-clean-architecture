package com.michiura.domain.usecase.characterdetails

import com.michiura.domain.repository.MarvelRepository
import com.michiura.domain.repository.states.Result

class CharacterDetailsUseCase(
    private val repository: MarvelRepository
) {
    suspend operator fun invoke(characterId: Int): Result =
        repository.fetchCharacterDetails(characterId = characterId)
}
