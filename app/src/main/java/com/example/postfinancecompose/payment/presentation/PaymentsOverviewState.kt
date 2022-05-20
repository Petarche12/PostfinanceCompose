package com.example.postfinancecompose.payment.presentation

import com.example.postfinancecompose.payment.models.Bill
import com.example.postfinancecompose.payment.models.Recipient

sealed class BillSectionState {
    object Undefined : BillSectionState()
    object Inactive : BillSectionState()
    object Insufficient : BillSectionState()
    class Valid(val bills: List<Bill> = emptyList()) : BillSectionState()
}

sealed class RecommendedRecipientsState {
    object Undefined : RecommendedRecipientsState()
    class Valid(val recipients: List<Recipient> = emptyList()) : RecommendedRecipientsState()
}

data class PaymentsOverviewState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val recommendedRecipientsState: RecommendedRecipientsState = RecommendedRecipientsState.Undefined,
    val billSectionState: BillSectionState = BillSectionState.Undefined,
)
