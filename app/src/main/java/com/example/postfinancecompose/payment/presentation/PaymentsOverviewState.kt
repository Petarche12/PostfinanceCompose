package com.example.postfinancecompose.payment.presentation

import com.example.postfinancecompose.payment.models.Recipient

data class PaymentsOverviewState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val recommendedRecipients: List<Recipient> = emptyList()
)
