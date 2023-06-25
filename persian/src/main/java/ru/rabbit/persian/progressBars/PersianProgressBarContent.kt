package ru.rabbit.persian.progressBars

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import kotlin.math.roundToInt

object PersianProgressBarContent {

    @Composable
    fun Text(
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onSurface,
        textStyle: TextStyle = MaterialTheme.typography.labelSmall
    ) = Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = LocalCircularProgress.current?.getProgressInPercent() ?: "∞",
            color = color,
            style = textStyle,
            modifier = Modifier
        )
    }

}

@SuppressWarnings("MagicNumber")
internal fun Float.getProgressInPercent(): String = "${(this * 10).roundToInt()}"

internal val LocalCircularProgress = compositionLocalOf<Float?> {
    error("No progress provided")
}