package com.michiura.datasource.repositories

import com.michiura.datasource.repositories.states.MarvelRepositoryState

interface MarvelRepository {
    suspend fun fetchCharactersList(): MarvelRepositoryState
    suspend fun fetchCharacterDetails(characterId: Int): MarvelRepositoryState
}
