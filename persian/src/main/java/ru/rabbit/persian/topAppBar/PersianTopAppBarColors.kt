package ru.rabbit.persian.topAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianContentStateDisabled

@Immutable
data class TopAppBarColors(
    val background: Color,
    val contentColor: Color,
    val iconColor: Color,
    val disabledIconColor: Color
)

object PersianTopAppBarColors {

    @Composable
    fun Primary(
        background: Color = MaterialTheme.colorScheme.surface,
        contentColor: Color = MaterialTheme.colorScheme.onSurface,
        iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledIconColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianContentStateDisabled)
    ) = remember(
        background,
        contentColor,
        iconColor,
        disabledIconColor
    ) {
        TopAppBarColors(
            background = background,
            contentColor = contentColor,
            iconColor = iconColor,
            disabledIconColor = disabledIconColor
        )
    }

}

internal val LocalPersianTopAppBarColors = compositionLocalOf<TopAppBarColors> {
    error("No TopAppBarsColors provided")
}