package com.michiura.presentation.view.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michiura.datasource.network.MarvelServiceFactory
import com.michiura.domain.repository.MarvelRepository
import com.michiura.domain.usecase.characterslist.CharactersListUseCase
import com.michiura.presentation.view.viewmodel.CharactersListViewModel

class CharactersListViewModelFactory : ViewModelProvider.Factory {
    private val charactersListUseCase = CharactersListUseCase(
        repository = MarvelRepository()
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersListViewModel::class.java)) {
            return CharactersListViewModel(charactersListUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
