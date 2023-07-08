package ru.rabbit.persian.topAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ru.rabbit.persian.buttons.PersianButton
import ru.rabbit.persian.counter.PersianBadge
import ru.rabbit.persian.counter.PersianCounterSizes
import ru.rabbit.persian.foundation.PersianComponentStyle
import ru.rabbit.persian.foundation.icons
import ru.rabbit.persian.iconButtons.PersianIconButton
import ru.rabbit.persian.iconButtons.PersianIconButtonColors

object PersianTopAppBarRight {

    private const val MAX_ACTIONS = 3

    @Composable
    fun Icons(
        actions: List<ActionItem>,
    ): Int {
        val colors = LocalPersianTopAppBarColors.current
        val showAsActionItems = actions.take(MAX_ACTIONS - 1)
        val overflowItems = actions.subtract(showAsActionItems.toSet()).toList()
        showAsActionItems.forEach { action ->
            if (action.badgeCount > 0) {
                PersianBadge.Primary(
                    sizes = PersianCounterSizes.medium(
                        badgeHorizontalOffset = (-15).dp,
                        badgeVerticalOffset = 18.dp
                    )
                ) {
                    PersianIconButton.Primary(
                        icon = action.icon,
                        style = PersianComponentStyle.STANDARD,
                        colors = PersianIconButtonColors.primary(
                            style = PersianComponentStyle.STANDARD,
                            containerColor = colors.iconColor
                        ),
                        onClick = action.onClick
                    )
                }
            } else {
                PersianIconButton.Primary(
                    icon = action.icon,
                    style = PersianComponentStyle.STANDARD,
                    colors = PersianIconButtonColors.primary(
                        style = PersianComponentStyle.STANDARD,
                        containerColor = colors.iconColor
                    ),
                    onClick = action.onClick
                )
            }
        }
        OverflowMenu(
            actions = overflowItems,
            overflowIcon = MaterialTheme.icons.moreVert
        )
        return showAsActionItems.size+1
    }

    @Composable
    fun Button(
        modifier: Modifier = Modifier,
        text: String,
        onClick: () -> Unit
    ): Int {
        PersianButton.Primary(
            modifier = modifier,
            text = text,
            onClick = onClick,
            style = PersianComponentStyle.STANDARD
        )
        return 1
    }

}

data class ActionItem(
    val icon: Painter,
    val title: String,
    val contentDescription: String,
    val badgeCount: Int = 0,
    val onClick: () -> Unit,
)