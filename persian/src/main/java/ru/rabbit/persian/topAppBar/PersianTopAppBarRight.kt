package ru.rabbit.persian.topAppBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        expanded: MutableState<Boolean> = remember { mutableStateOf(false) }
    ) {
        val colors = LocalPersianTopAppBarColors.current
        val showAsActionItemsCount = if (actions.size > MAX_ACTIONS) MAX_ACTIONS -1 else MAX_ACTIONS
        val showAsActionItems = actions.take(showAsActionItemsCount)
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
        if (overflowItems.isNotEmpty()) {
            OverflowMenu(
                actions = overflowItems,
                expanded = expanded,
                overflowIcon = MaterialTheme.icons.moreVert
            )
        }
    }

    @Composable
    fun Button(
        modifier: Modifier = Modifier,
        text: String,
        onClick: () -> Unit
    ) {
        PersianButton.Primary(
            modifier = modifier,
            text = text,
            onClick = onClick,
            style = PersianComponentStyle.STANDARD
        )
    }

}

data class ActionItem(
    val icon: Painter,
    val title: String,
    val contentDescription: String,
    val badgeCount: Int = 0,
    val onClick: () -> Unit,
)