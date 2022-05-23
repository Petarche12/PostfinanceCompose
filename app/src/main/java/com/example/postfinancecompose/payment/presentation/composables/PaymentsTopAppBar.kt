package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.postfinancecompose.ui.common_composables.BackIconButton

//TODO make text,color,style as parameters in order to be reusable if same app bar is used in multiple screens
@Composable
fun PaymentsTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(modifier = modifier, elevation = 0.dp) {
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

@Preview
@Composable
fun PaymentsTopAppBarPreview() {
    PaymentsTopAppBar()
}