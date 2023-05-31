package com.michiura.domain.usecases.characterslist

import com.michiura.domain.repositories.states.MarvelRepositoryState

interface CharactersListUseCase {
    suspend fun fetchCharactersList(): MarvelRepositoryState
}