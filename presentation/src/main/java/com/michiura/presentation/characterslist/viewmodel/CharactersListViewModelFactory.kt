package com.michiura.presentation.characterslist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michiura.domain.repository.MarvelRepository
import com.michiura.domain.usecase.characterdetails.CharacterDetailsUseCase
import com.michiura.domain.usecase.characterslist.CharactersListUseCase

class CharactersListViewModelFactory : ViewModelProvider.Factory {
    private val charactersListUseCase = CharactersListUseCase(
        repository = MarvelRepository()
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            CharactersListUseCase::class.java
        ).newInstance(charactersListUseCase)
}
