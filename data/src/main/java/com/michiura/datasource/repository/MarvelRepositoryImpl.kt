package com.michiura.datasource.repository

import com.michiura.datasource.datasource.remote.MarvelRemoteService
import com.michiura.datasource.mappers.CharactersDataMapper
import com.michiura.datasource.repository.states.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelRepositoryImpl(
    private val marvelRemoteService: MarvelRemoteService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MarvelRepository {

    override suspend fun fetchCharactersList(): Result =
        withContext(dispatcher) {
            return@withContext try {
                Result.Success(
                    response = CharactersDataMapper.mapCharacterWrapperResponseToEntity(
                        characterWrapperResponse = marvelRemoteService.getCharactersList()
                    )
                )
            } catch (e: Exception) {
                Result.Error(
                    errorMessage = e.message.toString()
                )
            }
        }

    override suspend fun fetchCharacterDetails(characterId: Int): Result =
        withContext(dispatcher) {
            return@withContext try {
                Result.Success(
                    response = CharactersDataMapper.mapCharacterWrapperResponseToEntity(
                        characterWrapperResponse = marvelRemoteService.getCharacterDetails(
                            characterId = characterId
                        )
                    )
                )
            } catch (e: Exception) {
                Result.Error(
                    errorMessage = e.message.toString()
                )
            }
        }
}
