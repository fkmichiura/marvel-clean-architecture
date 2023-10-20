package com.michiura.datasource.repository

import com.michiura.datasource.datasource.remote.MarvelRemoteService
import com.michiura.datasource.network.MarvelServiceFactory
import com.michiura.datasource.network.response.CharacterWrapperResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelRepository(
    private val marvelRemoteService: MarvelRemoteService = MarvelServiceFactory.getMarvelService(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun fetchCharactersList(): CharacterWrapperResponse =
        withContext(dispatcher) {
            marvelRemoteService.getCharactersList()
        }

    suspend fun fetchCharacterDetails(characterId: Int): CharacterWrapperResponse =
        withContext(dispatcher) {
            marvelRemoteService.getCharacterDetails(characterId = characterId)
        }
}
