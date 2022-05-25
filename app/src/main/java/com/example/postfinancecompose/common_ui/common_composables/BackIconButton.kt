package com.example.postfinancecompose.common_ui.common_composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackIconButton(modifier: Modifier = Modifier) {
    IconButton(modifier = modifier, onClick = {
        //TODO go back
    }) {
        Icon(
            imageVector = Icons.Filled.ArrowBackIosNew,
            contentDescription = "Back navigation icon"
        )
    }
}

@Preview
@Composable
fun BackIconButtonPreview() {
    BackIconButton()
}