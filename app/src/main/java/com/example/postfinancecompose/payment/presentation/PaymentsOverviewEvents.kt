package com.example.postfinancecompose.payment.presentation

sealed class PaymentsOverviewEvents {
    object OnCaptureReceiptClicked : PaymentsOverviewEvents()
    object OnNewOrderClicked : PaymentsOverviewEvents()
    object OnTransferClicked : PaymentsOverviewEvents()
}
