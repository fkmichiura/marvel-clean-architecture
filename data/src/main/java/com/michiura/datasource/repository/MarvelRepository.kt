package com.michiura.data.repository

import com.michiura.data.repository.states.MarvelRepositoryState

interface MarvelRepository {
    suspend fun fetchCharactersList(): MarvelRepositoryState
    suspend fun fetchCharacterDetails(characterId: Int): MarvelRepositoryState
}
