package com.example.postfinancecompose.payment.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postfinancecompose.payment.presentation.composables.PaymentsHeader
import com.example.postfinancecompose.payment.presentation.composables.PaymentsTopAppBar
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun PaymentsScreen(
    scaffoldState: ScaffoldState,
    paymentsViewModel: PaymentsViewModel = hiltViewModel(),
    topBackgroundColor: Color = MaterialTheme.colors.primary,
) {

    val context = LocalContext.current
    val spacing = LocalSpacing.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            PaymentsTopAppBar()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawRect(
                        color = topBackgroundColor,
                        size = Size(
                            width = this.size.width,
                            height = this.size.height / 4.2f
                        )
                    )
                }
                .padding(paddingValues)
        ) {
            LazyColumn {
                item {
                    PaymentsHeader(modifier = Modifier.padding(0.dp, 130.dp, 0.dp, 0.dp))
                }
            }
        }
    }

}

@Preview
@Composable
fun PaymentsScreenPreview() {
    PaymentsHeader()
}


