package com.michiura.datasource.repository.states

import com.michiura.datasource.network.response.CharacterWrapperResponse

sealed class MarvelRepositoryState {
    data class MarvelResponseSuccess(val response: CharacterWrapperResponse) :
        MarvelRepositoryState()

    data class MarvelResponseError(val errorMessage: String) : MarvelRepositoryState()
}
