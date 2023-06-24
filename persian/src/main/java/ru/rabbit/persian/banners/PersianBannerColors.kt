package ru.rabbit.persian.banners

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Immutable
data class BannerColors(
    val background: Color,
    val iconColor: Color,
    val textColor: Color
)

object PersianBannerColors{

    @Composable
    fun tertiary(
        background: Color = MaterialTheme.colorScheme.tertiaryContainer,
        iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        textColor: Color = MaterialTheme.colorScheme.onSurface
    ) = remember(
        background,
        iconColor,
        textColor
    ){
        BannerColors(
            background = background,
            iconColor = iconColor,
            textColor = textColor
        )
    }
}