package ru.rabbit.persian.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.foundation.spacing

object PersianForm {

    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        subhead: (@Composable PersianFormSubhead.() -> Unit)? = null,
        content: @Composable PersianFormContent.() -> Unit,
        caption: String? = null,
        captionTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
        captionColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraExtraSmall)
        ) {
            if (subhead != null) {
                PersianFormSubhead.subhead()
            }
            PersianFormContent.content()
            Text(
                text = caption ?: "",
                style = captionTextStyle,
                color = captionColor(enabled, captionColor).value
            )
        }
    }
}

@Composable
private fun captionColor(
    enabled: Boolean,
    captionColor: Color
): State<Color> {
    val color = when (enabled) {
        true -> captionColor
        false -> MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled)
    }
    return rememberUpdatedState(newValue = color)
}