package com.example.postfinancecompose.payment.models

data class Order(
    val name: String = "Mobility Crashing",
    val expirationDate: String = "27.02.2020", //TODO replace with date object
    val currency: String = "CHF",
    val amount: Float = 170.00f
)
