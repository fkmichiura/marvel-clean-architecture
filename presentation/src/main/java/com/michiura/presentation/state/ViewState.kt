package com.michiura.presentation.state

sealed class ViewState<out T> {
    data class Success<out T>(val data: T) : ViewState<T>()
    data class Error(val exception: Exception) : ViewState<Nothing>()
}
