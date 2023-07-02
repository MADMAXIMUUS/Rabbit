package ru.rabbit.persian.menus

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import ru.rabbit.persian.foundation.icons

object PersianMenuItem {

    @Composable
    fun Primary(
        title: String,
        modifier: Modifier = Modifier,
        onItemClick: () -> Unit,
        colors: MenuItemColors = PersianMenuItemColors.primary(),
        textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
        enabled: Boolean = true,
        isNegative: Boolean = false,
        leadingIcon: Painter? = null,
        expandIcon: Painter = MaterialTheme.icons.chevronRight,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    ) {
        val leftIcon: (@Composable () -> Unit)? = if (leadingIcon == null) null else {
            run {
                Icon(
                    painter = leadingIcon,
                    contentDescription = "",
                    tint = colors.leadingIconColor(enabled = enabled, isNegative = isNegative).value
                )
            }
        }
        DropdownMenuItem(
            modifier = modifier,
            text = {
                Text(
                    text = title,
                    style = textStyle,
                    color = colors.titleColor(enabled = enabled, isNegative = isNegative).value
                )
            },
            leadingIcon = leftIcon,
            onClick = onItemClick,
            interactionSource = interactionSource
        )
    }

}