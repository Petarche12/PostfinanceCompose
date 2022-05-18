package com.example.postfinancecompose.payment.presentation.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconSize: Dp = 36.dp,
    buttonTitle: String,
    backgroundColor: Color = Color.Transparent
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .width(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            modifier = Modifier.wrapContentSize(),
            onClick = {}
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .background(Color.White),
                imageVector = icon,
                contentDescription = buttonTitle,
            )
        }
        Text(
            text = buttonTitle,
            fontSize = 12.sp,
            color = Color.Black,
            maxLines = 2,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun HeaderItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    iconSize: Dp = 36.dp,
    buttonTitle: String,
    backgroundColor: Color = Color.Transparent
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .width(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            modifier = Modifier.wrapContentSize(),
            onClick = {}
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .background(Color.White),
                painter = painterResource(id = icon),
                contentDescription = buttonTitle,
            )
        }
        Text(
            text = buttonTitle,
            fontSize = 12.sp,
            color = Color.Black,
            maxLines = 2,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun HeaderItemPreview() {
    HeaderItem(icon = Icons.Filled.AddAPhoto, buttonTitle = "Capture receipt")
}