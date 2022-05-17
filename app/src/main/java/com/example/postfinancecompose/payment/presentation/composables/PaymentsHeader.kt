package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.postfinancecompose.R

@Composable
fun PaymentsHeader(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(backgroundColor),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        HeaderItem(
            iconDrawable = R.drawable.ic_launcher_foreground,
            buttonTitle = "Capture receipt",
            iconSize = 40.dp
        )
        HeaderItem(
            iconDrawable = R.drawable.ic_launcher_foreground,
            buttonTitle = "New order",
            iconSize = 44.dp
        )
        HeaderItem(
            iconDrawable = R.drawable.ic_launcher_foreground,
            buttonTitle = "Transfer",
            iconSize = 40.dp
        )
    }
}

@Preview
@Composable
fun PaymentsHeaderPreview() {
    PaymentsHeader()
}