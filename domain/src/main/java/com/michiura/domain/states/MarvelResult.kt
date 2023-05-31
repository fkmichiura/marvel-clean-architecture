package com.michiura.domain.states

import com.michiura.domain.entities.CharacterContainerEntity

sealed class MarvelResult {
    data class ResponseSuccess(val entity: CharacterContainerEntity) : MarvelResult()
    data class ResponseError(val errorMessage: String) : MarvelResult()
}
