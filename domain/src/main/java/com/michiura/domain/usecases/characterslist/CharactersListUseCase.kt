package com.michiura.domain.usecases.characterslist

import com.michiura.datasource.repository.MarvelRepository
import com.michiura.datasource.repository.states.Result

class CharactersListUseCase(
    private val repository: MarvelRepository
) {
    suspend operator fun invoke(): Result =
        repository.fetchCharactersList()
}
