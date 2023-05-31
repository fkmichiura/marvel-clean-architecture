package com.michiura.datasource.repository.states

import com.michiura.datasource.network.response.CharacterWrapperResponse
import com.michiura.domain.states.MarvelResult

sealed class MarvelRepositoryState {
    data class MarvelResponseSuccess(val response: CharacterWrapperResponse) :
        MarvelResult()

    data class MarvelResponseError(val errorMessage: String) : MarvelResult()
}
