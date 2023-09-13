package com.michiura.presentation.view.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michiura.datasource.network.MarvelServiceFactory
import com.michiura.domain.repository.MarvelRepository
import com.michiura.domain.usecase.characterdetails.CharacterDetailsUseCase
import com.michiura.domain.usecase.characterslist.CharactersListUseCase
import com.michiura.presentation.view.viewmodel.CharacterDetailsViewModel
import com.michiura.presentation.view.viewmodel.CharactersListViewModel

class CharacterDetailsViewModelFactory : ViewModelProvider.Factory {
    private val charactersListUseCase = CharacterDetailsUseCase(
        repository = MarvelRepository()
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterDetailsViewModel::class.java)) {
            return CharacterDetailsViewModel(charactersListUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
