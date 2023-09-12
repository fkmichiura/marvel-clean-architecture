package com.michiura.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michiura.domain.repository.entities.CharacterEntity
import com.michiura.domain.repository.states.Result
import com.michiura.domain.usecase.characterdetails.CharacterDetailsUseCase
import com.michiura.presentation.state.ViewState
import kotlinx.coroutines.launch

class MarvelCharacterDetailsViewModel(
    private val characterDetailsUseCase: CharacterDetailsUseCase
) : ViewModel() {

    private val _characterDetailsViewState: MutableLiveData<ViewState<CharacterEntity>> =
        MutableLiveData<ViewState<CharacterEntity>>()
    val characterDetailsViewState: LiveData<ViewState<CharacterEntity>> = _characterDetailsViewState

    fun getCharacterDetails(characterId: Int) {

        viewModelScope.launch {

            when (
                val result: Result<CharacterEntity> = characterDetailsUseCase.invoke(
                    characterId = characterId
                )
            ) {
                is Result.Success -> {
                    _characterDetailsViewState.postValue(
                        ViewState.Success(data = result.data)
                    )
                }

                is Result.Error -> {
                    _characterDetailsViewState.postValue(
                        ViewState.Error(exception = result.exception)
                    )
                }
            }
        }
    }
}
