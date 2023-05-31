package com.michiura.domain.repository

import com.michiura.datasource.repository.states.RepositoryState

interface MarvelRepository {
    suspend fun fetchCharactersList(): RepositoryState
    suspend fun fetchCharacterDetails(characterId: Int): RepositoryState
}
