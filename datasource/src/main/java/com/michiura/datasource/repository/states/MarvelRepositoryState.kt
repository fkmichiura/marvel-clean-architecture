package com.michiura.datasource.repository.states

import com.michiura.datasource.repository.response.CharactersResponse

sealed class MarvelRepositoryState {
    data class MarvelResponseSuccess(val response: CharactersResponse) : MarvelRepositoryState()
    data class MarvelResponseError(val errorMessage: String) : MarvelRepositoryState()
}
