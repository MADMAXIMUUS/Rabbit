package ru.rabbit.persian.menus

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.elevation

@Immutable
data class MenuColors(
    val backgroundColor: Color,
    val itemColors: MenuItemColors
)

object PersianMenuColors {

    @Composable
    fun primary(
        backgroundColor: Color = MaterialTheme.colorScheme
            .surfaceColorAtElevation(MaterialTheme.elevation.small),
        itemColors: MenuItemColors = PersianMenuItemColors.primary()
    ) = remember(backgroundColor, itemColors) {
        MenuColors(
            backgroundColor = backgroundColor,
            itemColors = itemColors
        )
    }
}