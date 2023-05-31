package com.michiura.datasource.repository

import com.michiura.datasource.datasource.remote.MarvelRemoteService
import com.michiura.datasource.repository.states.RepositoryState
import com.michiura.domain.repository.MarvelRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelRepositoryImpl(
    private val marvelRemoteService: MarvelRemoteService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MarvelRepository {

    override suspend fun fetchCharactersList(): RepositoryState =
        withContext(dispatcher) {
            return@withContext try {
                val response = marvelRemoteService.getCharactersList()
                RepositoryState.ResponseSuccess(response = response)
            } catch (e: Exception) {
                RepositoryState.ResponseError(
                    errorMessage = e.message.toString()
                )
            }
        }

    override suspend fun fetchCharacterDetails(characterId: Int): RepositoryState =
        withContext(dispatcher) {
            return@withContext try {
                val response = marvelRemoteService.getCharacterDetails(characterId = characterId)
                RepositoryState.ResponseSuccess(response = response)
            } catch (e: Exception) {
                RepositoryState.ResponseError(
                    errorMessage = e.message.toString()
                )
            }
        }
}
