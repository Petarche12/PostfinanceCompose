package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postfinancecompose.R
import com.example.postfinancecompose.payment.models.Order
import com.example.postfinancecompose.ui.common_composables.getShimmerBrush
import com.example.postfinancecompose.ui.theme.LocalSpacing


@Composable
fun OrderRow(modifier: Modifier = Modifier, order: Order) {

    val spacing = LocalSpacing.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(spacing.spaceMedium, 0.dp, spacing.spaceMedium, 0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.align(Alignment.CenterStart)) {
                Image(
                    modifier = modifier
                        .fillMaxHeight()
                        .aspectRatio(1f),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = order.name, fontSize = 18.sp)
                    Text(text = "Expiration date: 27.02.2020")
                }
            }


            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "CHF",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                Text(
                    text = "170.00",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun LoadingOrderRow(modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current

    Row(
        modifier = modifier
            .height(45.dp)
            .fillMaxWidth()
            .padding(spacing.spaceMedium)
    ) {
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .width(80.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(getShimmerBrush())
        )
        Spacer(modifier = Modifier.width(spacing.spaceLarge))
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .width(240.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(getShimmerBrush())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingOrderRowPreview() {
    OrderRow(order = Order("Mobility Carsharing"))
}