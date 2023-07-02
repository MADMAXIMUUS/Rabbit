package ru.rabbit.persian.menus

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianContentStateDisabled

@Immutable
class MenuItemColors internal constructor(
    //Title Color
    private val titleColor: Color,
    private val negativeTitleColor: Color,
    private val disabledTitleColor: Color,

    //Leading Icon Color
    private val leadingIconColor: Color,
    private val negativeLeadingIconColor: Color,
    private val disabledLeadingIconColor: Color,

    //Expend Icon Color
    private val expendIconColor: Color,
    private val negativeExpandIconColor: Color,
    private val disabledExpandIconColor: Color
) {

    @Composable
    internal fun titleColor(
        enabled: Boolean,
        isNegative: Boolean
    ): State<Color> {

        val targetValue = when {
            !enabled -> disabledTitleColor
            isNegative -> negativeTitleColor

            else -> titleColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun leadingIconColor(
        enabled: Boolean,
        isNegative: Boolean
    ): State<Color> {

        val targetValue = when {
            !enabled -> disabledLeadingIconColor
            isNegative -> negativeLeadingIconColor

            else -> leadingIconColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun expandIconColor(
        enabled: Boolean,
        isNegative: Boolean
    ): State<Color> {

        val targetValue = when {
            !enabled -> disabledExpandIconColor
            isNegative -> negativeExpandIconColor

            else -> expendIconColor
        }
        return rememberUpdatedState(targetValue)
    }
}

object PersianMenuItemColors {

    @Composable
    fun primary(
        titleColor: Color = MaterialTheme.colorScheme.onSurface,
        negativeTitleColor: Color = MaterialTheme.colorScheme.error,
        disabledTitleColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled),
        leadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        negativeLeadingIconColor: Color = MaterialTheme.colorScheme.error,
        disabledLeadingIconColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled),
        expendIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        negativeExpandIconColor: Color = MaterialTheme.colorScheme.error,
        disabledExpandIconColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled)
    ): MenuItemColors =
        MenuItemColors(
            titleColor = titleColor,
            negativeTitleColor = negativeTitleColor,
            disabledTitleColor = disabledTitleColor,
            leadingIconColor = leadingIconColor,
            negativeLeadingIconColor = negativeLeadingIconColor,
            disabledLeadingIconColor = disabledLeadingIconColor,
            expendIconColor = expendIconColor,
            negativeExpandIconColor = negativeExpandIconColor,
            disabledExpandIconColor = disabledExpandIconColor
        )
}