package ru.rabbit.persian.iconButtons.toggle

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianComponentStyle
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.foundation.PersianStatesDisabled

data class IconButtonColors(
    val containerColor: Color,
    val checkedContainerColor: Color,
    val contentColor: Color,
    val checkedContentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color
)

object PersianToggleIconButtonColors {

    @Composable
    fun primary(
        style: PersianComponentStyle,
        containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
        tonalContainerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        checkedContainerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.primary,
        tonalContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        checkedContentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianContentStateDisabled)
    ): IconButtonColors = remember(
        containerColor,
        checkedContainerColor,
        contentColor,
        checkedContentColor,
        disabledContainerColor,
        disabledContentColor
    ) {
        when (style) {
            PersianComponentStyle.FILL -> IconButtonColors(
                containerColor = containerColor,
                checkedContainerColor = checkedContainerColor,
                contentColor = contentColor,
                checkedContentColor = checkedContentColor,
                disabledContainerColor = disabledContainerColor,
                disabledContentColor = disabledContentColor
            )

            PersianComponentStyle.OUTLINED -> IconButtonColors(
                containerColor = Color.Transparent,
                checkedContainerColor = checkedContainerColor,
                contentColor = contentColor,
                checkedContentColor = checkedContentColor,
                disabledContainerColor = disabledContainerColor,
                disabledContentColor = disabledContentColor
            )

            PersianComponentStyle.STANDARD -> IconButtonColors(
                containerColor = Color.Transparent,
                checkedContainerColor = Color.Transparent,
                contentColor = contentColor,
                checkedContentColor = checkedContainerColor,
                disabledContainerColor = disabledContainerColor,
                disabledContentColor = disabledContentColor
            )

            PersianComponentStyle.TONAL -> IconButtonColors(
                containerColor = tonalContainerColor,
                checkedContainerColor = checkedContainerColor,
                contentColor = tonalContentColor,
                checkedContentColor = checkedContentColor,
                disabledContainerColor = disabledContainerColor,
                disabledContentColor = disabledContentColor
            )
        }
    }
}