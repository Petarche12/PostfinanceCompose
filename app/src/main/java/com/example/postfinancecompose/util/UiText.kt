package com.example.postfinancecompose.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


/**
 * We use this so we can send string resources from viewmodel,
 * it would be good to replace string parameters in composables with UiText parameter
 * and when we want to access the actual string we can just call the asString function.
 */
//TODO replace all String parameters in composables with UiText
sealed class UiText {
    data class DynamicString(val text: String) : UiText()
    class StringResource(val resId: Int, vararg val args: Any?) : UiText()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> text
            is StringResource -> stringResource(resId, args)
        }
    }

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId, args)
        }
    }
}
