package ru.rabbit.persian.buttons

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianComponentStyle
import ru.rabbit.persian.foundation.PersianStatesDisabled

@Immutable
data class ButtonColors(
    val contentColor: Color,
    val containerColor: Color,
    val disabledContentColor: Color,
    val disabledContainerColor: Color
) {
    fun contentColor(enabled: Boolean) = if (enabled) contentColor else disabledContentColor

    fun containerColor(enabled: Boolean) = if (enabled) containerColor else disabledContainerColor
}

object PersianButtonColors {

    @Composable
    fun primary(
        style: PersianComponentStyle,
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = when (style) {
        PersianComponentStyle.Fill -> ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )

        PersianComponentStyle.Outlined -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )

        PersianComponentStyle.Text -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )
    }


    @Composable
    fun secondary(
        style: PersianComponentStyle,
        containerColor: Color = MaterialTheme.colorScheme.secondary,
        contentColor: Color = MaterialTheme.colorScheme.onSecondary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = when (style) {
        PersianComponentStyle.Fill -> ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )

        PersianComponentStyle.Outlined -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )

        PersianComponentStyle.Text -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )
    }

    @Composable
    fun tertiary(
        style: PersianComponentStyle,
        containerColor: Color = MaterialTheme.colorScheme.tertiary,
        contentColor: Color = MaterialTheme.colorScheme.onTertiary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = when (style) {
        PersianComponentStyle.Fill -> ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )

        PersianComponentStyle.Outlined -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )

        PersianComponentStyle.Text -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )
    }

    @Composable
    fun negative(
        style: PersianComponentStyle,
        containerColor: Color = MaterialTheme.colorScheme.error,
        contentColor: Color = MaterialTheme.colorScheme.onError,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = when (style) {
        PersianComponentStyle.Fill -> ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )

        PersianComponentStyle.Outlined -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )

        PersianComponentStyle.Text -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )
    }

    @Composable
    fun neutral(
        style: PersianComponentStyle,
        containerColor: Color = MaterialTheme.colorScheme.inverseSurface,
        contentColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = when (style) {
        PersianComponentStyle.Fill -> ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )

        PersianComponentStyle.Outlined -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )

        PersianComponentStyle.Text -> ButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )
    }

}