package ru.rabbit.persian.tabs

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Immutable
data class TabColors(
    val backgroundColor: Color,
    val indicatorColor: Color,
    val activeColor: Color,
    val disabledColor: Color
)

object PersianTabsColors {

    @Composable
    fun primary(
        backgroundColor: Color = MaterialTheme.colorScheme.surface,
        indicatorColor: Color = MaterialTheme.colorScheme.primary,
        activeColor: Color = MaterialTheme.colorScheme.primary,
        disabledColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ): TabColors = remember(
        backgroundColor, indicatorColor, activeColor, disabledColor
    ) {
        TabColors(
            backgroundColor = backgroundColor,
            indicatorColor = indicatorColor,
            activeColor = activeColor,
            disabledColor = disabledColor
        )
    }
}