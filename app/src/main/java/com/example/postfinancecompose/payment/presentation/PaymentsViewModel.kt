package com.example.postfinancecompose.payment.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postfinancecompose.payment.models.Recipient
import com.example.postfinancecompose.util.UiText
import com.plcoding.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val dummyRecipients = mutableListOf(
        Recipient(UiText.DynamicString("Petarche Lazarevski")),
        Recipient(UiText.DynamicString("Petarche Lazarevski")),
        Recipient(UiText.DynamicString("Petarche Lazarevski")),
        Recipient(UiText.DynamicString("Test Testovski")),
        Recipient(UiText.DynamicString("Petarche Lazarevski")),
        Recipient(UiText.DynamicString("Petarche Lazarevski")),
        Recipient(UiText.DynamicString("Sara Lazarevska")),
        Recipient(UiText.DynamicString("Petarche Lazarevski")),
        Recipient(UiText.DynamicString("Petarche Lazarevski")),
    )

    var state by mutableStateOf(PaymentsOverviewState())
        private set

    //This is not respecting the unidirectional dataflow where events go up and state goes down
    //However currently this is the way I pass some events like showing snackbars, etc, need
    //to do additional research if this is the right way
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    init {
        loadData()
    }

    fun onEvent(event: PaymentsOverviewEvents) {
        viewModelScope.launch {
            when (event) {
                PaymentsOverviewEvents.OnCaptureReceiptClicked -> {
                    _uiEvent.send(UiEvent.ShowSnackbar(UiText.DynamicString("Capture clicked")))
                }
                PaymentsOverviewEvents.OnNewOrderClicked -> {
                    _uiEvent.send(UiEvent.ShowSnackbar(UiText.DynamicString("New order clicked")))
                }
                PaymentsOverviewEvents.OnTransferClicked -> {
                    _uiEvent.send(UiEvent.ShowSnackbar(UiText.DynamicString("On transfer clicked")))
                }
            }
        }
    }

    private fun loadData() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            delay(2000L)
            state = state.copy(isLoading = false, recommendedRecipients = dummyRecipients)
        }
    }
}