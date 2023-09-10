package com.michiura.datasource.repository.states

import com.michiura.datasource.entities.CharacterContainerEntity

sealed class Result {
    data class Success(val response: CharacterContainerEntity) : Result()

    data class Error(val errorMessage: String) : Result()
}
