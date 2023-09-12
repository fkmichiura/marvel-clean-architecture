package com.michiura.domain.repository

import com.michiura.datasource.datasource.remote.MarvelRemoteService
import com.michiura.datasource.network.MarvelServiceFactory
import com.michiura.domain.repository.entities.CharacterEntity
import com.michiura.domain.repository.mappers.CharactersDataMapper
import com.michiura.domain.repository.states.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelRepository(
    private val marvelRemoteService: MarvelRemoteService = MarvelServiceFactory.getMarvelService(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun fetchCharactersList(): Result<List<CharacterEntity>> =
        withContext(dispatcher) {
            return@withContext try {
                Result.Success(
                    data = CharactersDataMapper.mapCharacterWrapperResponseToCharactersListEntity(
                        characterWrapperResponse = marvelRemoteService.getCharactersList()
                    )
                )
            } catch (e: Exception) {
                Result.Error(exception = e)
            }
        }

    suspend fun fetchCharacterDetails(characterId: Int): Result<CharacterEntity> =
        withContext(dispatcher) {
            return@withContext try {
                Result.Success(
                    data = CharactersDataMapper.mapCharacterWrapperResponseToCharacterEntity(
                        characterWrapperResponse = marvelRemoteService.getCharacterDetails(
                            characterId = characterId
                        )
                    )
                )
            } catch (e: Exception) {
                Result.Error(exception = e)
            }
        }
}
