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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.postfinancecompose.R
import com.example.postfinancecompose.common_ui.common_composables.getShimmerBrush
import com.example.postfinancecompose.common_ui.theme.LocalSpacing
import com.example.postfinancecompose.payment.models.Order


@Composable
fun OrderRow(modifier: Modifier = Modifier, order: Order) {

    val spacing = LocalSpacing.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(spacing.spaceMedium, 0.dp, spacing.spaceMedium, 0.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth(),
        ) {
            val (row1, row2) = createRefs()
            Row(modifier = Modifier.constrainAs(row1) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(row2.start, margin = spacing.spaceMedium)
                width = Dimension.fillToConstraints
            }
            ) {
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
                    Text(
                        text = order.name,
                        fontSize = 18.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        text = "Expiration date: ${order.expirationDate}",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .constrainAs(row2) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = order.currency,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                Text(
                    text = order.amount.toString(),
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
    OrderRow(order = Order("Mobility Carsharing dasdasdasdasd"))
}