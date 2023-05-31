package com.michiura.datasource.repositories

import com.michiura.datasource.datasource.remote.MarvelRemoteService
import com.michiura.datasource.mappers.CharactersDataMapper
import com.michiura.datasource.repositories.states.MarvelRepositoryState
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
                    response = CharactersDataMapper().mapCharacterWrapperResponseToEntity(
                        characterWrapperResponse = response
                    )
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
                    response = CharactersDataMapper().mapCharacterWrapperResponseToEntity(
                        characterWrapperResponse = response
                    )
                )
            } catch (e: Exception) {
                MarvelRepositoryState.MarvelResponseError(
                    errorMessage = e.message.toString()
                )
            }
        }
}