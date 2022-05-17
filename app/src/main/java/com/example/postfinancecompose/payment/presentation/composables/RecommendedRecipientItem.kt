package com.example.postfinancecompose.payment.presentation.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postfinancecompose.R
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun RecommendedRecipientItem(
    modifier: Modifier = Modifier,
    @DrawableRes stringRes: Int,
    recipientName: String,
    onClick: (() -> Unit)? = null
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    Column(
        modifier = modifier
            .size(60.dp)
            .background(Color.Transparent)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(spacing.spaceSmall),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = modifier.size(24.dp),
            painter = painterResource(id = stringRes),
            contentDescription = "Icon for recipient $recipientName"
        )
        Text(
            text = recipientName,
            color = Color.Black,
            fontSize = 8.sp,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun RecommendedRecipientItemPreview() {
    RecommendedRecipientItem(
        stringRes = R.drawable.ic_launcher_foreground,
        recipientName = "Petarche Lazarevski"
    )
}