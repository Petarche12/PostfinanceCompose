package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.postfinancecompose.R
import com.example.postfinancecompose.common_ui.theme.LocalSpacing
import com.example.postfinancecompose.payment.presentation.RecommendedRecipientsState

@Composable
fun RecipientsSection(
    modifier: Modifier = Modifier,
    recommendedRecipientsState: RecommendedRecipientsState
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        SectionHeader(sectionTitle = "Recommended recipients")
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            when (recommendedRecipientsState) {

                RecommendedRecipientsState.Undefined -> {
                    val numberOfRepeats = 3
                    repeat(numberOfRepeats) { index ->
                        item {
                            RecommendedSectionItem(index = index, size = numberOfRepeats) {
                                RecommendedRecipientItemLoading()
                            }
                        }
                    }
                }

                is RecommendedRecipientsState.Valid -> {
                    itemsIndexed(recommendedRecipientsState.recipients) { index, recipient ->
                        RecommendedSectionItem(
                            index = index,
                            size = recommendedRecipientsState.recipients.size
                        ) {
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
