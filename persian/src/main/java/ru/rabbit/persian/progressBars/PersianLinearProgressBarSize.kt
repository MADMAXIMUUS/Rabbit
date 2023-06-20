package ru.rabbit.persian.progressBars

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class LinearProgressBarSizes(
    val strokeSize: Dp
)

object PersianLinearProgressBarSize {

    @Composable
    fun Small(
        strokeSize: Dp = 2.dp
    ) = remember(strokeSize) {
        LinearProgressBarSizes(
            strokeSize = strokeSize
        )
    }
}