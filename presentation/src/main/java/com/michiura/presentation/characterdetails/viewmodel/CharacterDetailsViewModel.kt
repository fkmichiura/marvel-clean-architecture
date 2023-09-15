package com.michiura.presentation.characterdetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michiura.domain.repository.entities.CharacterDetailsEntity
import com.michiura.domain.repository.states.Result
import com.michiura.domain.usecase.characterdetails.CharacterDetailsUseCase
import com.michiura.presentation.commons.ViewState
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(
    private val characterDetailsUseCase: CharacterDetailsUseCase
) : ViewModel() {

    private val _characterDetailsViewState: MutableLiveData<ViewState<CharacterDetailsEntity>> =
        MutableLiveData<ViewState<CharacterDetailsEntity>>()
    val characterDetailsViewState: LiveData<ViewState<CharacterDetailsEntity>> =
        _characterDetailsViewState

    fun getCharacterDetails(characterId: Int) {

        viewModelScope.launch {

            when (
                val result: Result<CharacterDetailsEntity> = characterDetailsUseCase.invoke(
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
