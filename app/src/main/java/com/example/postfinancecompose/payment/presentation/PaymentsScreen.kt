package com.example.postfinancecompose.payment.presentation

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postfinancecompose.payment.presentation.composables.Header
import com.example.postfinancecompose.payment.presentation.composables.HeaderItem
import com.example.postfinancecompose.payment.presentation.composables.PaymentsTopAppBar
import com.example.postfinancecompose.payment.presentation.composables.RecipientsSection
import com.example.postfinancecompose.ui.theme.LocalSpacing
import com.plcoding.core.util.UiEvent

@Composable
fun PaymentsScreen(
    scaffoldState: ScaffoldState,
    paymentsViewModel: PaymentsViewModel = hiltViewModel(),
    topBackgroundColor: Color = MaterialTheme.colors.primary,
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
            LazyColumn {
                item {
                    Header(
                        isProgressIndicatorVisible = state.isLoading,
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
                        recipients = state.recommendedRecipients
                    )
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


