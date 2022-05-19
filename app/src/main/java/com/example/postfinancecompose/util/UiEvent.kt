package com.plcoding.core.util

import com.example.postfinancecompose.util.UiText

sealed class UiEvent {
    object NavigateUp : UiEvent()
    data class ShowSnackbar(val message: UiText) : UiEvent()
}
