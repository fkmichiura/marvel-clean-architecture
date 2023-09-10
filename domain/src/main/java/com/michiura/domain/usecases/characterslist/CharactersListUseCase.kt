package com.michiura.domain.usecases.characterslist

import com.michiura.domain.repository.MarvelRepository
import com.michiura.domain.states.MarvelResult

class CharactersListUseCaseImpl(private val repository: MarvelRepository) : CharactersListUseCase {

    override suspend fun fetchCharactersList(): MarvelResult =
        repository.fetchCharactersList()
}
