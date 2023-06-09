package ru.rabbit.persian.counter

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Immutable
data class CounterColors(
    val backgroundColor: Color,
    val textColor: Color
)

object PersianCounterColors {

    @Composable
    fun default(
        backgroundColor: Color = MaterialTheme.colorScheme.error,
        textColor: Color = MaterialTheme.colorScheme.onError
    ) = remember(backgroundColor, textColor) {
        CounterColors(
            backgroundColor = backgroundColor,
            textColor = textColor
        )
    }

    @Composable
    fun tonal(
        backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
        textColor: Color = MaterialTheme.colorScheme.onPrimaryContainer
    ) = remember(backgroundColor, textColor) {
        CounterColors(
            backgroundColor = backgroundColor,
            textColor = textColor
        )
    }

    @Composable
    fun transparent(
        backgroundColor: Color = Color.Transparent,
        textColor: Color = MaterialTheme.colorScheme.onSurface
    ) = remember(backgroundColor, textColor) {
        CounterColors(
            backgroundColor = backgroundColor,
            textColor = textColor
        )
    }

}