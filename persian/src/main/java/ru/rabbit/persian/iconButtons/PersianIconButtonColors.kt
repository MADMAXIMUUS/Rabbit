package ru.rabbit.persian.iconButtons

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianComponentStyle
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.foundation.PersianStatesDisabled

data class IconButtonColors(
    val containerColor: Color,
    val tonalContainerColor: Color,
    val contentColor: Color,
    val tonalContentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color
)

object PersianIconButtonColors {

    @Composable
    fun primary(
        style: PersianComponentStyle,
        containerColor: Color = MaterialTheme.colorScheme.primary,
        tonalContainerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        tonalContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianContentStateDisabled)
    ): IconButtonColors = remember(
        containerColor,
        tonalContainerColor,
        contentColor,
        tonalContentColor,
        disabledContainerColor,
        disabledContentColor
    ){
        when (style) {
            PersianComponentStyle.FILL -> IconButtonColors(
                containerColor = containerColor,
                tonalContainerColor = tonalContainerColor,
                contentColor = contentColor,
                tonalContentColor = tonalContentColor,
                disabledContainerColor = disabledContainerColor,
                disabledContentColor = disabledContentColor
            )

            PersianComponentStyle.OUTLINED -> IconButtonColors(
                containerColor = Color.Transparent,
                tonalContainerColor = tonalContainerColor,
                contentColor = containerColor,
                tonalContentColor = tonalContentColor,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = disabledContainerColor
            )
            PersianComponentStyle.STANDARD -> IconButtonColors(
                containerColor = Color.Transparent,
                tonalContainerColor = tonalContainerColor,
                contentColor = containerColor,
                tonalContentColor = tonalContentColor,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = disabledContainerColor
            )
            PersianComponentStyle.TONAL -> IconButtonColors(
                containerColor = containerColor,
                tonalContainerColor = tonalContainerColor,
                contentColor = contentColor,
                tonalContentColor = tonalContentColor,
                disabledContainerColor = disabledContainerColor,
                disabledContentColor = disabledContentColor
            )
        }
    }
}