package ru.rabbit.persian.topAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import ru.rabbit.persian.avatars.PersianAvatars
import ru.rabbit.persian.avatars.PersianAvatarsSizes
import ru.rabbit.persian.foundation.PersianComponentStyle
import ru.rabbit.persian.foundation.icons
import ru.rabbit.persian.iconButtons.PersianIconButton
import ru.rabbit.persian.iconButtons.PersianIconButtonColors

object PersianTopAppBarLeft {

    @Composable
    fun Navigation(
        iconTint: Color = MaterialTheme.colorScheme.onSurface,
        icon: Painter = MaterialTheme.icons.arrowBack,
        onClick: () -> Unit
    ) {
        PersianIconButton.Primary(
            icon = icon,
            style = PersianComponentStyle.STANDARD,
            colors = PersianIconButtonColors.primary(
                style = PersianComponentStyle.STANDARD,
                containerColor = iconTint
            ),
            onClick = onClick
        )
    }

    @Composable
    fun Close(
        iconTint: Color = MaterialTheme.colorScheme.onSurface,
        icon: Painter = MaterialTheme.icons.close,
        onClick: () -> Unit
    ) {
        PersianIconButton.Primary(
            icon = icon,
            style = PersianComponentStyle.STANDARD,
            colors = PersianIconButtonColors.primary(
                style = PersianComponentStyle.STANDARD,
                containerColor = iconTint
            ),
            onClick = onClick
        )
    }

    @Composable
    fun Avatar(
        image: String,
        onClick: () -> Unit
    ) {
        PersianAvatars.Round(
            imageUrl = image,
            size = PersianAvatarsSizes.medium(),
            onClick = onClick
        )
    }

}