package com.michiura.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michiura.domain.repository.entities.CharacterEntity
import com.michiura.domain.repository.states.Result
import com.michiura.domain.usecase.characterslist.CharactersListUseCase
import com.michiura.presentation.state.ViewState
import kotlinx.coroutines.launch

class CharactersListViewModel(
    private val charactersListUseCase: CharactersListUseCase
) : ViewModel() {

    private val _charactersListViewState: MutableLiveData<ViewState<List<CharacterEntity>>> =
        MutableLiveData<ViewState<List<CharacterEntity>>>()
    val charactersListViewState: LiveData<ViewState<List<CharacterEntity>>> =
        _charactersListViewState

    fun getCharactersList() {

        viewModelScope.launch {

            when (
                val result: Result<List<CharacterEntity>> = charactersListUseCase.invoke()
            ) {
                is Result.Success -> {
                    _charactersListViewState.postValue(
                        ViewState.Success(data = result.data)
                    )
                }

                is Result.Error -> {
                    _charactersListViewState.postValue(
                        ViewState.Error(exception = result.exception)
                    )
                }
            }
        }
    }
}
