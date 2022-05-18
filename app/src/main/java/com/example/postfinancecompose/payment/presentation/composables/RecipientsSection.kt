package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.postfinancecompose.R
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun RecipientsSection(modifier: Modifier = Modifier, recipients: List<String> = emptyList()) {

    val spacing = LocalSpacing.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        SectionHeader(sectionTitle = "Recommended recipients")
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(recipients) { index, item ->
                if (index == 0) {
                    Spacer(modifier = Modifier.width(spacing.spaceMedium))
                } else {
                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                }
                RecommendedRecipientItem(
                    stringRes = R.drawable.ic_launcher_foreground,
                    recipientName = item
                )
                if (index == recipients.size - 1) {
                    Spacer(modifier = Modifier.width(spacing.spaceMedium))
                }
            }
        }
    }

}

@Preview
@Composable
fun RecipientSectionPreview() {
    RecipientsSection(
        recipients = listOf(
            "Petarche Lazarevski",
            "Petarche Lazarevski",
            "Petarche Lazarevski",
            "Petarche Lazarevski",
            "Petarche Lazarevski",
            "Petarche Lazarevski",
            "Petarche Lazarevski",
            "Petarche Lazarevski",
        )
    )
}