package com.example.postfinancecompose.payment.presentation

import com.example.postfinancecompose.payment.models.Bill
import com.example.postfinancecompose.payment.models.Order
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

sealed class OrdersState {
    object Undefined : OrdersState()
    class Valid(val orders: List<Order> = emptyList()) : OrdersState()
}

data class PaymentsOverviewState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val recommendedRecipientsState: RecommendedRecipientsState = RecommendedRecipientsState.Undefined,
    val billSectionState: BillSectionState = BillSectionState.Undefined,
    val pendingIndividualOrdersState: OrdersState = OrdersState.Undefined,
    val standingOrdersState: OrdersState = OrdersState.Undefined
)
