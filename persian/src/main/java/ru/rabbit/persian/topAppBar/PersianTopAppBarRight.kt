package ru.rabbit.persian.topAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import ru.rabbit.persian.foundation.PersianComponentStyle
import ru.rabbit.persian.iconButtons.PersianIconButton
import ru.rabbit.persian.iconButtons.PersianIconButtonColors

object PersianTopAppBarRight {

    private const val MAX_ACTIONS = 3

    @Composable
    fun Icons(
        overflowIcon: Painter? = null,
        actions: List<ActionItem>? = null,
    ) {
        val colors = LocalPersianTopAppBarColors.current
        actions?.forEach { action ->
            PersianIconButton.Primary(
                icon = action.icon,
                colors = PersianIconButtonColors.primary(
                    style = PersianComponentStyle.STANDARD,
                    containerColor = colors.iconColor
                ),
                onClick = action.onClick
            )
        }
    }

}

data class ActionItem(
    val icon: Painter,
    val contentDescription: String?,
    val badgeCount: Int = 0,
    val content: @Composable () -> Unit = {},
    val onClick: () -> Unit,
)