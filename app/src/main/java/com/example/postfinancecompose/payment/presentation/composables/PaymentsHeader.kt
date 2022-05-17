package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.postfinancecompose.R

@Composable
fun PaymentsHeader(
    modifier: Modifier = Modifier,
    topBackgroundColor: Color = MaterialTheme.colors.primary,
    backgroundColor: Color = Color.White,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(backgroundColor)
            .drawBehind {
                drawRect(
                    color = topBackgroundColor,
                    size = Size(this.size.width, this.size.height / 1.5f)
                )
            }
            .padding(0.dp, 105.dp, 0.dp, 0.dp),
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