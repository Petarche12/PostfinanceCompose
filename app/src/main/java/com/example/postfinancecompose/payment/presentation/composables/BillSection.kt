package com.example.postfinancecompose.payment.presentation.composables

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.postfinancecompose.R
import com.example.postfinancecompose.payment.models.Bill
import com.example.postfinancecompose.payment.presentation.BillSectionState
import com.example.postfinancecompose.ui.common_composables.getShimmerBrush
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun BillSection(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    billSectionState: BillSectionState,
    onButtonClicked: () -> Unit
) {
    Column(modifier = modifier) {
        SectionHeader(sectionTitle = sectionTitle)
        when (billSectionState) {

            BillSectionState.Undefined -> {
                BillSectionLoading(modifier = modifier)
            }

            BillSectionState.Inactive -> {
                val explanationText = "Receive and pay invoices electronically"
                val buttonText = "Activate eBill"
                NoBillsView(
                    explanationText = explanationText,
                    buttonText = buttonText,
                    imageRes = R.drawable.ic_launcher_foreground,
                    onButtonClicked = onButtonClicked
                )
            }

            BillSectionState.Insufficient -> {
                val explanationText =
                    "Your authorizations for displaying eBill invoices are no longer sufficient."
                val buttonText = "eBill settings"
                NoBillsView(
                    explanationText = explanationText,
                    buttonText = buttonText,
                    imageRes = null,
                    onButtonClicked = onButtonClicked,
                )
            }
            is BillSectionState.Valid -> {
                BillsRow(eBills = billSectionState.bills)
            }
        }
    }
}

@Composable
fun BillSectionLoading(modifier: Modifier = Modifier, brush: Brush = getShimmerBrush()) {
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
fun NoBillsView(
    modifier: Modifier = Modifier,
    explanationText: String,
    buttonText: String,
    imageRes: Int?,
    onButtonClicked: () -> Unit
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            imageRes?.let {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "e-bill image"
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Text(text = explanationText)
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .border(width = 1.dp, Color.Black, RoundedCornerShape(25.dp))
                    .background(Color.Transparent)
                    .clickable {
                        onButtonClicked()
                    }
                    .padding(20.dp),
                text = buttonText,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun BillsRow(modifier: Modifier = Modifier, eBills: List<Bill>) {
    //TODO
}

@Preview(showBackground = true)
@Composable
fun BillSectionPreview() {
    BillSectionLoading()
}