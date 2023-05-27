package com.michiura.datasource.repository

import com.michiura.datasource.network.MarvelRemoteService
import com.michiura.datasource.repository.states.MarvelRepositoryState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelRepositoryImpl(
    private val marvelRemoteService: MarvelRemoteService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MarvelRepository {

    override suspend fun fetchCharactersList(): MarvelRepositoryState =
        withContext(dispatcher) {
            return@withContext try {
                val response = marvelRemoteService.getCharactersList()
                MarvelRepositoryState.MarvelResponseSuccess(
                    response = response
                )
            } catch (e: Exception) {
                MarvelRepositoryState.MarvelResponseError(
                    errorMessage = e.message.toString()
                )
            }
        }

    override suspend fun fetchCharacterDetails(characterId: Int): MarvelRepositoryState =
        withContext(dispatcher) {
            return@withContext try {
                val response = marvelRemoteService.getCharacterDetails(characterId = characterId)
                MarvelRepositoryState.MarvelResponseSuccess(
                    response = response
                )
            } catch (e: Exception) {
                MarvelRepositoryState.MarvelResponseError(
                    errorMessage = e.message.toString()
                )
            }
        }
}