package com.michiura.domain.usecases.characterslist

import com.michiura.domain.states.MarvelResult

interface CharactersListUseCase {
    suspend fun fetchCharactersList(): MarvelResult
}
