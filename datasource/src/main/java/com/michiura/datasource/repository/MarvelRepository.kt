package com.michiura.datasource.repository

import com.michiura.datasource.repository.states.MarvelRepositoryState

interface MarvelRepository {
    suspend fun fetchCharactersList(): MarvelRepositoryState
    suspend fun fetchCharacterDetails(characterId: Int): MarvelRepositoryState
}
