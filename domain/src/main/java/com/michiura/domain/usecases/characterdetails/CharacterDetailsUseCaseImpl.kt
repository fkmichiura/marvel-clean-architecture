package com.michiura.domain.usecases.characterslist

import com.michiura.domain.repositories.MarvelRepository
import com.michiura.domain.repositories.states.MarvelRepositoryState

class CharactersListUseCaseImpl(private val repository: MarvelRepository) : CharactersListUseCase {

    override suspend fun fetchCharactersList(): MarvelRepositoryState =
        repository.fetchCharactersList()
}
