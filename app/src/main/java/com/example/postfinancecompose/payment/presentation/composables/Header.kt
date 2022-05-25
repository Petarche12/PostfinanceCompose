package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Header(
    modifier: Modifier = Modifier,
    topBackgroundColor: Color = MaterialTheme.colors.primary,
    backgroundColor: Color = Color.White,
    isLoading: Boolean = true,
    buttons: @Composable (() -> Unit)? = null
) {
    Box(
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
    ) {
        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 132.dp, 0.dp, 0.dp)
                    .height(2.dp),
                backgroundColor = Color.Green,
                color = Color.Red,
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(0.dp, 106.dp, 0.dp, 0.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            buttons?.invoke()
        }
    }
}

@Composable
fun Header2(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    isLoading: Boolean = true,
    buttonsHeight: Dp,
    buttons: @Composable (() -> Unit)? = null
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(backgroundColor)
    ) {
        val (progressIndicatorRef, buttonsRowRef) = createRefs()
        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .constrainAs(progressIndicatorRef) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                backgroundColor = Color.Green,
                color = Color.Red,
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .constrainAs(buttonsRowRef) {
                    top.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .absoluteOffset(0.dp, -buttonsHeight / 2),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            buttons?.invoke()
        }
    }
}


@Preview
@Composable
fun PaymentsHeaderPreview() {
    Header2(buttonsHeight = 24.dp)
}