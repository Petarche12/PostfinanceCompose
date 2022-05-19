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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postfinancecompose.R
import com.example.postfinancecompose.payment.presentation.composables.*
import com.example.postfinancecompose.ui.theme.LocalSpacing
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
                onRefresh = { paymentsViewModel.onEvent(PaymentsOverviewEvents.OnSwipeToRefreshTriggered) }) {
                LazyColumn {
                    item {
                        Header(
                            isLoading = state.isLoading,
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
                                    iconSize = 48.dp
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
                        Spacer(modifier = Modifier.height(spacing.spaceMedium))
                        RecipientsSection(
                            isLoading = state.isLoading,
                            recipients = state.recommendedRecipients
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceMedium))
                        BillSection(
                            isLoading = state.isLoading,
                            sectionTitle = "eBill",
                            imageRes = R.drawable.ic_launcher_foreground
                        ) {
                            //TODO implement on click
                        }
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
    Header()
}


