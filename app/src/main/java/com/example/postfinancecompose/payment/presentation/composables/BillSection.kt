package com.example.postfinancecompose.payment.presentation.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.postfinancecompose.ui.common_composables.getShimmerBrush
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun BillSection(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    sectionTitle: String,
    @DrawableRes imageRes: Int,
    onActivateEBillClicked: () -> Unit
) {
    when {
        isLoading == false -> {
            NoActiveBill(
                modifier = modifier,
                sectionTitle = sectionTitle,
                imageRes = imageRes,
                onActivateEBillClicked = onActivateEBillClicked
            )
        }
        isLoading == true -> {
            SectionHeader(sectionTitle = "eBill")
            LoadingBillSection(modifier = modifier)
        }
    }
}

@Composable
fun LoadingBillSection(modifier: Modifier = Modifier, brush: Brush = getShimmerBrush()) {
    val spacing = LocalSpacing.current
    LazyRow(
        modifier = modifier.padding(spacing.spaceMedium)
    ) {
        repeat(2) {
            item {
                Column(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.DarkGray)
                        .padding(spacing.spaceMedium),
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Spacer(
                        modifier = Modifier
                            .width(110.dp)
                            .height(spacing.spaceMedium)
                            .clip(RoundedCornerShape(10.dp))
                            .background(brush)
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    Spacer(
                        modifier = Modifier
                            .width(110.dp)
                            .height(spacing.spaceMedium)
                            .clip(RoundedCornerShape(10.dp))
                            .background(brush)
                            .padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
            }
        }
    }
}


@Composable
fun NoActiveBill(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    @DrawableRes imageRes: Int,
    onActivateEBillClicked: () -> Unit
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        SectionHeader(sectionTitle = sectionTitle)
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "e-bill image"
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Text(text = "Receive and pay invoices electronically")
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .border(width = 1.dp, Color.Black, RoundedCornerShape(25.dp))
                    .background(Color.Transparent)
                    .clickable {
                        onActivateEBillClicked()
                    }
                    .padding(20.dp),
                text = "Activate eBill",
                textAlign = TextAlign.Center,
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BillSectionPreview() {
//    BillSection(
//        isLoading = false,
//        sectionTitle = "eBill",
//        imageRes = R.drawable.ic_launcher_foreground
//    ) {
//
//    }
    LoadingBillSection()
}