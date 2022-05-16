package com.example.postfinancecompose.payment.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postfinancecompose.payment.presentation.composables.BackIconButton
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun PaymentsScreen(
    scaffoldState: ScaffoldState,
    paymentsViewModel: PaymentsViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val spacing = LocalSpacing.current

    Scaffold(
        topBar = {
            PaymentsAppBar()
        }
    ) { paddingValues ->

        Box(modifier = Modifier.padding(paddingValues)) {

        }

    }

}

@Composable
fun PaymentsAppBar() {
    TopAppBar {
        Box(modifier = Modifier.weight(1f)) {
            BackIconButton(Modifier.align(Alignment.CenterStart))
            Text(
                text = "Payments",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

