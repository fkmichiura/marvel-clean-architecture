package com.michiura.data.repository.states

import com.michiura.data.repository.response.CharactersResponse

sealed class MarvelRepositoryState {
    data class MarvelResponseSuccess(val response: CharactersResponse) : MarvelRepositoryState()
    data class MarvelResponseError(val errorMessage: String) : MarvelRepositoryState()
}
