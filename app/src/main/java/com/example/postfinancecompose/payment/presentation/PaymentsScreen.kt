package com.example.postfinancecompose.payment.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postfinancecompose.payment.presentation.composables.PaymentsTopAppBar
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
            PaymentsTopAppBar()
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues), Alignment.Center) {
            LazyColumn {

            }
        }
    }

}



