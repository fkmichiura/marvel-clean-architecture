package com.michiura.presentation.commons

sealed class ViewState<out T> {
    data class Success<out T>(val data: T) : ViewState<T>()
    data class Error(val exception: Exception) : ViewState<Nothing>()
    data class Loading(val showLoading: Boolean = false) : ViewState<Nothing>()
}
