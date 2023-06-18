package ru.rabbit.persian.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow

object PersianButton {

    @Composable
    fun Primary(
        text: String,
        modifier: Modifier = Modifier,
        icon: Painter? = null,
        iconSide: IconSide = IconSide.LEFT,
        enabled: Boolean = true,
        state: State = State.Enabled,
        style: PersianButtonStyle = PersianButtonStyle.Fill,
        colors: ButtonColors = PersianButtonColors.Primary(style),
        size: ButtonSizes = PersianButtonSizes.Medium(),
        onClick: () -> Unit
    ) = PersianButtonImpl(
        modifier = modifier,
        text = text,
        enabled = enabled,
        style = style,
        colors = colors,
        state = state,
        size = size,
        icon = icon,
        iconSide = iconSide,
        onClick = onClick
    )
}

enum class IconSide{ LEFT, RIGHT}
enum class PersianButtonStyle { Fill, Outlined, Text}
enum class State { Enabled, Hovered, Focused, Pressed, Disabled, Loading }

@Composable
private fun PersianButtonImpl(
    text: String,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    iconSide: IconSide? = null,
    enabled: Boolean,
    style: PersianButtonStyle,
    colors: ButtonColors,
    state: State,
    size: ButtonSizes,
    onClick: () -> Unit
) {

    when (style){
        PersianButtonStyle.Fill -> {
            val iconButton = @Composable {
                icon?.let {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier.size(size.iconSize)
                    )
                }
            }
            Button(
                enabled = enabled,
                modifier = modifier
                    .height(size.height),
                colors = colors,
                contentPadding = size.contentPadding,
                onClick = onClick
            ) {
                if (iconSide == IconSide.LEFT) iconButton()
                Text(
                    modifier = Modifier.weight(1f, fill = false),
                    text = text,
                    style = size.textStyle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                if (iconSide == IconSide.RIGHT) iconButton()
                ButtonDefaults.outlinedButtonColors()
            }
        }
        PersianButtonStyle.Outlined -> TODO()
        PersianButtonStyle.Text -> TODO()
    }
}