package com.example.postfinancecompose.payment.presentation

sealed class PaymentsOverviewEvents {
    object OnCaptureReceiptClicked : PaymentsOverviewEvents()
    object OnNewOrderClicked : PaymentsOverviewEvents()
    object OnTransferClicked : PaymentsOverviewEvents()
    object OnSwipeToRefreshTriggered : PaymentsOverviewEvents()
    object OnActivateEBillClicked : PaymentsOverviewEvents()
    object OnEBillSettingsClicked : PaymentsOverviewEvents()
    object OnEBillClicked : PaymentsOverviewEvents()
    object OnPendingOrdersShowMoreClicked : PaymentsOverviewEvents()
    object OnStandingOrdersShowMoreClicked : PaymentsOverviewEvents()
}
