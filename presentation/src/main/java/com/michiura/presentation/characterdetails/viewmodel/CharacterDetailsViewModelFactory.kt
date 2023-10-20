package com.michiura.presentation.characterdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michiura.datasource.repository.MarvelRepository
import com.michiura.domain.usecase.characterdetails.CharacterDetailsUseCase

class CharacterDetailsViewModelFactory : ViewModelProvider.Factory {
    private val characterDetailsUseCase = CharacterDetailsUseCase(
        repository = MarvelRepository()
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            CharacterDetailsUseCase::class.java
        ).newInstance(characterDetailsUseCase)
}
