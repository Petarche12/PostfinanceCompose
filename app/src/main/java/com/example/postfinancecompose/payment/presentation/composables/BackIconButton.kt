package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.postfinancecompose.R

@Composable
fun BackIconButton(modifier: Modifier = Modifier) {
    IconButton(modifier = modifier, onClick = {
        //TODO go back
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
            contentDescription = "Back navigation icon",
            tint = MaterialTheme.colors.onPrimary
        )
    }
}