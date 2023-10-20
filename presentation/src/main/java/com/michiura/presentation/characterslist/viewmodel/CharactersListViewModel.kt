package com.michiura.presentation.characterslist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michiura.domain.entities.CharacterEntity
import com.michiura.domain.states.Result
import com.michiura.domain.usecase.characterslist.CharactersListUseCase
import com.michiura.presentation.commons.ViewState
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

            _charactersListViewState.value = ViewState.Loading(showLoading = true)

            when (
                val result: Result<List<CharacterEntity>> = charactersListUseCase.invoke()
            ) {
                is Result.Success -> {
                    _charactersListViewState.value = ViewState.Loading()
                    _charactersListViewState.postValue(
                        ViewState.Success(data = result.data)
                    )
                }

                is Result.Error -> {
                    _charactersListViewState.value = ViewState.Loading()
                    _charactersListViewState.postValue(
                        ViewState.Error(exception = result.exception)
                    )
                }
            }
        }
    }
}
