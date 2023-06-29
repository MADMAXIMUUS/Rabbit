package ru.rabbit.persian.topAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.foundation.elevation

@Immutable
data class TopAppBarColors(
    val background: Color,
    val scrolledBackgroundColor: Color,
    val contentColor: Color,
    val iconColor: Color,
    val disabledIconColor: Color,
)

object PersianTopAppBarColors {

    @Composable
    fun primary(
        background: Color = MaterialTheme.colorScheme.surface,
        scrolledBackgroundColor: Color = MaterialTheme.colorScheme
            .surfaceColorAtElevation(MaterialTheme.elevation.small),
        contentColor: Color = MaterialTheme.colorScheme.onSurface,
        iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledIconColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianContentStateDisabled)
    ) = remember(
        background,
        contentColor,
        scrolledBackgroundColor,
        iconColor,
        disabledIconColor
    ) {
        TopAppBarColors(
            background = background,
            scrolledBackgroundColor = scrolledBackgroundColor,
            contentColor = contentColor,
            iconColor = iconColor,
            disabledIconColor = disabledIconColor
        )
    }

}

internal val LocalPersianTopAppBarColors = compositionLocalOf<TopAppBarColors> {
    error("No TopAppBarsColors provided")
}