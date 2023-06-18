package ru.rabbit.persian.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class ButtonSizes(
    val textStyle: TextStyle,
    val height: Dp,
    val iconSize: Dp,
    val contentPadding: PaddingValues
)

object PersianButtonSizes {

    @Composable
    fun Large(
        fontSize: TextStyle = MaterialTheme.typography.titleMedium,
        height: Dp = 52.dp,
        iconSize: Dp = 24.dp,
        contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
    ): ButtonSizes = remember(
        fontSize,
        height,
        iconSize,
        contentPadding
    ) {
        ButtonSizes(
            textStyle = fontSize,
            height = height,
            iconSize = iconSize,
            contentPadding = contentPadding
        )
    }

    @Composable
    fun Medium(
        fontSize: TextStyle = MaterialTheme.typography.labelLarge,
        height: Dp = 44.dp,
        iconSize: Dp = 20.dp,
        contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
    ): ButtonSizes = remember(
        fontSize,
        height,
        iconSize,
        contentPadding
    ) {
        ButtonSizes(
            textStyle = fontSize,
            height = height,
            iconSize = iconSize,
            contentPadding = contentPadding
        )
    }

    @Composable
    fun Small(
        fontSize: TextStyle = MaterialTheme.typography.titleSmall,
        height: Dp = 36.dp,
        iconSize: Dp = 18.dp,
        contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ): ButtonSizes = remember(
        fontSize,
        height,
        iconSize,
        contentPadding
    ) {
        ButtonSizes(
            textStyle = fontSize,
            height = height,
            iconSize = iconSize,
            contentPadding = contentPadding
        )
    }
}