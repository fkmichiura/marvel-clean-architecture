package com.michiura.datasource.repository

import com.michiura.datasource.repository.states.Result

interface MarvelRepository {
    suspend fun fetchCharactersList(): Result
    suspend fun fetchCharacterDetails(characterId: Int): Result
}