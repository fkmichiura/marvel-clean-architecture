package com.michiura.datasource.repository.states

import com.michiura.datasource.network.response.CharacterWrapperResponse

sealed class RepositoryState {
    data class ResponseSuccess(val response: CharacterWrapperResponse) : RepositoryState()

    data class ResponseError(val errorMessage: String) : RepositoryState()
}
