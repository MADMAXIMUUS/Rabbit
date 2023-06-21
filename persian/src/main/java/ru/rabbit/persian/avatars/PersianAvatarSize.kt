package ru.rabbit.persian.avatars

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AvatarSize(
    val boxSizes: Dp
)

object PersianAvatarsSizes {

    @Composable
    fun large(
        boxSizes: Dp = 48.dp
    ) = remember(boxSizes) {
        AvatarSize(boxSizes)
    }

    @Composable
    fun medium(
        boxSizes: Dp = 32.dp
    ) = remember(boxSizes) {
        AvatarSize(boxSizes)
    }

    @Composable
    fun small(
        boxSizes: Dp = 24.dp
    ) = remember(boxSizes) {
        AvatarSize(boxSizes)
    }
}