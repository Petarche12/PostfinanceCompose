package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.postfinancecompose.R
import com.example.postfinancecompose.payment.models.Recipient
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun RecipientsSection(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    recipients: List<Recipient> = emptyList()
) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current

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
            if (isLoading) {
                val numberOfRepeats = 3
                repeat(numberOfRepeats) { index ->
                    item {
                        RecommendedSectionItem(index = index, size = numberOfRepeats) {
                            RecommendedRecipientItemLoading()
                        }
                    }
                }
            } else {
                itemsIndexed(recipients) { index, recipient ->
                    RecommendedSectionItem(index = index, size = recipients.size) {
                        RecommendedRecipientItem(
                            stringRes = R.drawable.ic_launcher_foreground,
                            recipientName = recipient.name.asString(context)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendedSectionItem(index: Int, size: Int = 0, item: @Composable () -> Unit) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current

    if (index == 0) {
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
    } else {
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
    }
    item.invoke()
    if (index == size - 1) {
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
    }
}

@Preview
@Composable
fun RecipientSectionPreview() {
    RecipientsSection(isLoading = false)
}