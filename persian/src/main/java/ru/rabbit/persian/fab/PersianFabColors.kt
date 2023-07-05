package ru.rabbit.persian.fab

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.elevation

@Immutable
data class FabColors(
    val backgroundColor: Color,
    val content: Color,
)

object PersianFabColors {

    @Composable
    fun primary(
        backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
        content: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    ) = remember(
        backgroundColor,
        content
    ) {
        FabColors(
            backgroundColor = backgroundColor,
            content = content,
        )
    }

    @Composable
    fun secondary(
        backgroundColor: Color = MaterialTheme.colorScheme.secondaryContainer,
        content: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    ) = remember(
        backgroundColor,
        content
    ) {
        FabColors(
            backgroundColor = backgroundColor,
            content = content
        )
    }

    @Composable
    fun tertiary(
        backgroundColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
        content: Color = MaterialTheme.colorScheme.onTertiaryContainer
    ) = remember(
        backgroundColor,
        content
    ) {
        FabColors(
            backgroundColor = backgroundColor,
            content = content
        )
    }

    @Composable
    fun neutral(
        backgroundColor: Color = MaterialTheme.colorScheme
            .surfaceColorAtElevation(MaterialTheme.elevation.medium),
        content: Color = MaterialTheme.colorScheme.primary
    ) = remember(
        backgroundColor,
        content
    ) {
        FabColors(
            backgroundColor = backgroundColor,
            content = content
        )
    }
}