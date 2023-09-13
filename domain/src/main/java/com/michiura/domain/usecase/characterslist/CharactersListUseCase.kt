package com.michiura.domain.usecase.characterslist

import com.michiura.domain.repository.MarvelRepository
import com.michiura.domain.repository.entities.CharacterEntity
import com.michiura.domain.repository.states.Result

class CharactersListUseCase(
    private val repository: MarvelRepository
) {
    suspend operator fun invoke(): Result<List<CharacterEntity>> = repository.fetchCharactersList()
}
