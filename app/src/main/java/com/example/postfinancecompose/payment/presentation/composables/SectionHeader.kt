package com.example.postfinancecompose.payment.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postfinancecompose.ui.theme.LocalSpacing

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    textColor: Color = Color.Black,
    textSize: TextUnit = 12.sp,
    lineColor: Color = Color.Black,
    buttonText: String = "Show all",
    buttonTextSize: TextUnit = 12.sp,
    buttonTextColor: Color = Color.Black,
    onButtonClick: (() -> Unit)? = null
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(spacing.spaceMedium, 0.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = sectionTitle,
                color = textColor,
                fontSize = textSize
            )
            onButtonClick?.let {
                Text(
                    modifier = Modifier
                        .clickable { onButtonClick() }
                        .align(Alignment.CenterEnd),
                    text = buttonText,
                    color = buttonTextColor,
                    fontSize = buttonTextSize
                )
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = lineColor.copy(alpha = 0.3f),
            thickness = 1.dp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview() {
    SectionHeader(sectionTitle = "Recommended recipients") {}
}