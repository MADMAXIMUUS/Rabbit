package ru.rabbit.persian.snackbar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.elevation

@Immutable
data class SnackbarColors(
    val backgroundColor: Color,
    val textColor: Color
)

object PersianSnackbarColors {
    @Composable
    fun primary(
        backgroundColor: Color = MaterialTheme.colorScheme.surfaceColorAtElevation(MaterialTheme.elevation.extraLarge),
        textColor: Color = MaterialTheme.colorScheme.onSurface
    ) = remember(backgroundColor, textColor) {
        SnackbarColors(
            backgroundColor = backgroundColor,
            textColor = textColor
        )
    }
}