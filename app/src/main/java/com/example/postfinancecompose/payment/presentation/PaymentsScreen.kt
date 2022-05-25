package com.example.postfinancecompose.payment.presentation

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postfinancecompose.common_ui.theme.LocalSpacing
import com.example.postfinancecompose.payment.presentation.composables.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.plcoding.core.util.UiEvent

@Composable
fun PaymentsScreen(
    scaffoldState: ScaffoldState,
    paymentsViewModel: PaymentsViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    val state = paymentsViewModel.state

    handleUiEventsFromViewModel(paymentsViewModel, scaffoldState, context)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            PaymentsTopAppBar()
        }
    ) { paddingValues ->
        SwipeRefresh(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
            onRefresh = { paymentsViewModel.onEvent(PaymentsOverviewEvents.OnSwipeToRefreshTriggered) }
        ) {
            LazyColumn {
                item {
                    val middleIconSize = 48.dp
                    Header2(
                        isLoading = state.isLoading,
                        buttonsHeight = middleIconSize,
                        buttons = {
                            Spacer(modifier = Modifier.width(spacing.spaceMedium))
                            HeaderItem(
                                icon = Icons.Outlined.PhotoCamera,
                                buttonTitle = "Capture receipt",
                                iconSize = 44.dp
                            ) {
                                paymentsViewModel.onEvent(PaymentsOverviewEvents.OnCaptureReceiptClicked)
                            }
                            HeaderItem(
                                icon = Icons.Outlined.AddCircle,
                                buttonTitle = "New order",
                                iconSize = middleIconSize
                            ) {
                                paymentsViewModel.onEvent(PaymentsOverviewEvents.OnNewOrderClicked)
                            }
                            HeaderItem(
                                icon = Icons.Filled.ArrowForward,
                                buttonTitle = "Transfer",
                                iconSize = 44.dp
                            ) {
                                paymentsViewModel.onEvent(PaymentsOverviewEvents.OnTransferClicked)
                            }
                            Spacer(modifier = Modifier.width(spacing.spaceMedium))
                        }
                    )

                    Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))

                    RecipientsSection(recommendedRecipientsState = state.recommendedRecipientsState)

                    Spacer(modifier = Modifier.height(spacing.spaceMedium))

                    BillSection(
                        sectionTitle = "eBill",
                        billSectionState = paymentsViewModel.state.billSectionState
                    ) {
                        when (paymentsViewModel.state.billSectionState) {
                            BillSectionState.Inactive -> {
                                paymentsViewModel.onEvent(PaymentsOverviewEvents.OnActivateEBillClicked)
                            }
                            BillSectionState.Insufficient -> {
                                paymentsViewModel.onEvent(PaymentsOverviewEvents.OnEBillSettingsClicked)
                            }
                            else -> Unit
                        }
                    }

                    Spacer(modifier = Modifier.height(spacing.spaceMedium))

                    OrdersSection(state = state.pendingIndividualOrdersState) {
                        SectionHeader(
                            sectionTitle = "Pending individual orders",
                            buttonText = "Show all",
                            buttonTextColor = Color.Black,
                            onButtonClick =
                            if (state.pendingIndividualOrdersState is OrdersState.Valid) {
                                { paymentsViewModel.onEvent(PaymentsOverviewEvents.OnPendingOrdersShowMoreClicked) }
                            } else null
                        )
                    }

                    OrdersSection(state = state.standingOrdersState) {
                        SectionHeader(
                            sectionTitle = "Standing orders",
                            buttonText = "Show all",
                            buttonTextColor = Color.Black,
                            onButtonClick =
                            if (state.standingOrdersState is OrdersState.Valid) {
                                { paymentsViewModel.onEvent(PaymentsOverviewEvents.OnPendingOrdersShowMoreClicked) }
                            } else null
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun handleUiEventsFromViewModel(
    paymentsViewModel: PaymentsViewModel,
    scaffoldState: ScaffoldState,
    context: Context
) {
    LaunchedEffect(key1 = scaffoldState) {
        paymentsViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
                else -> Unit
            }
        }
    }
}

@Preview
@Composable
fun PaymentsScreenPreview() {
    PaymentsScreen(scaffoldState = rememberScaffoldState(), hiltViewModel())
}


