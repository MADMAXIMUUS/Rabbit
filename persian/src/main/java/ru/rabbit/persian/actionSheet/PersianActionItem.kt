package ru.rabbit.persian.actionSheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.foundation.spacing

object PersianActionItem {

    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        actionItem: ActionItem,
        iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        textColor: Color = MaterialTheme.colorScheme.onSurface
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(
                    enabled = actionItem.enabled,
                    onClick = actionItem.onClick,
                    role = Role.Button
                )
                .padding(
                    start = MaterialTheme.spacing.medium,
                    top = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.medium,
                    end = 0.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
        ) {
            val iconColorExtended = when {
                !actionItem.enabled -> MaterialTheme.colorScheme.onSurface
                    .copy(alpha = PersianContentStateDisabled)

                actionItem.negative -> MaterialTheme.colorScheme.error
                else -> iconColor
            }
            val textColorExtended = when {
                !actionItem.enabled -> MaterialTheme.colorScheme.onSurface
                    .copy(alpha = PersianContentStateDisabled)

                actionItem.negative -> MaterialTheme.colorScheme.error
                else -> textColor
            }
            actionItem.leadingIcon?.let {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = it,
                    contentDescription = "",
                    tint = iconColorExtended
                )
            }
            Text(
                modifier = Modifier.height(24.dp),
                text = actionItem.text,
                style = MaterialTheme.typography.titleMedium,
                color = textColorExtended
            )
        }
    }

}

data class ActionItem(
    val text: String,
    val leadingIcon: Painter? = null,
    val enabled: Boolean = true,
    val negative: Boolean = false,
    val onClick: () -> Unit
)