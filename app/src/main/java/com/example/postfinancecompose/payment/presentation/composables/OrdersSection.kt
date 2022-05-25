package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.postfinancecompose.common_ui.theme.LocalSpacing
import com.example.postfinancecompose.payment.models.Order
import com.example.postfinancecompose.payment.presentation.OrdersState

@Composable
fun OrdersSection(
    modifier: Modifier = Modifier,
    state: OrdersState,
    sectionHeader: @Composable () -> Unit
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        when (state) {
            OrdersState.Undefined -> {
                sectionHeader.invoke()
                OrdersLoading()
            }
            is OrdersState.Valid -> {
                if (state.orders.isNotEmpty()) {
                    sectionHeader.invoke()
                    OrdersLoaded(
                        orders = state.orders
                    )
                }
            }
        }
    }
}

@Composable
fun OrdersLoaded(modifier: Modifier = Modifier, orders: List<Order>) {
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        repeat(5) {
            if (it == 0) {
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
            }
            OrderRow(order = orders[it])
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
    }
}

@Composable
fun OrdersLoading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
    ) {
        repeat(1) {
            LoadingOrderRow()
        }
    }
}