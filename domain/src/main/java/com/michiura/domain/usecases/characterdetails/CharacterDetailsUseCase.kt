package com.michiura.domain.usecases.characterdetails

import com.michiura.domain.entities.CharacterContainerEntity

interface CharacterDetailsUseCase {
    suspend fun fetchCharacterDetails(characterId: Int): Result<CharacterContainerEntity>
}
