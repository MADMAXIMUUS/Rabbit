package ru.madmax.rabbit.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class SnackbarVisualsCustom(
    override val message: String,
    override val actionLabel: String? = null,
    override val withDismissAction: Boolean = false,
    override val duration: SnackbarDuration = SnackbarDuration.Indefinite,
    val colors: SnackbarColorsCustom = SnackbarColorsCustom(),
    val isOnTop: Boolean = false,
    @DrawableRes val icon: Int? = null,
    @DrawableRes val closeIcon: Int? = null,
    val onAction: (() -> Unit)? = null,
    val onDismiss: (() -> Unit)? = null
) : SnackbarVisuals

data class SnackbarColorsCustom(
    val background: Color = Color.DarkGray,
    val border: Color = Color.DarkGray,
    val message: Color = Color.White,
    val action: Color = Color.Blue,
    val icon: Color = Color.White,
    val closeIcon: Color = Color.White
)

@Composable
fun TSnackbar(
    @DrawableRes icon: Int? = null,
    actionLabel: String? = null,
    @DrawableRes closeIcon: Int? = null,
    isOnTop: Boolean = false,
    message: String,
    colors: SnackbarColorsCustom = SnackbarColorsCustom(),
    onAction: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null
) {
    val configuration = LocalConfiguration.current

    val padding by remember {
        mutableStateOf(
            if (isOnTop) {
                PaddingValues(
                    start = 10.dp,
                    top = 50.dp,
                    bottom = configuration.screenHeightDp.dp - 100.dp,
                    end = 10.dp
                )
            } else {
                PaddingValues(horizontal = 10.dp, vertical = 40.dp)
            }
        )
    }

    Snackbar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .border(1.dp, color = colors.border, shape = MaterialTheme.shapes.large),
        shape = MaterialTheme.shapes.medium,
        containerColor = colors.background,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (icon != null) {
                        Icon(
                            modifier = Modifier
                                .size(35.dp),
                            painter = painterResource(id = icon),
                            contentDescription = "",
                            tint = colors.icon
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .weight(0.7f),
                        text = message,
                        style = MaterialTheme.typography.labelLarge,
                        color = colors.message
                    )
                    if (actionLabel != null) {
                        TTextButton(
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = colors.action
                            ),
                            onClick = {
                                if (onAction != null)
                                    onAction()
                            },
                            text = { Text(actionLabel) }
                        )
                    }
                    if (closeIcon != null) {
                        IconButton(
                            modifier = Modifier
                                .size(35.dp),
                            onClick = {
                                if (onDismiss != null)
                                    onDismiss()
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = colors.closeIcon
                            ),
                            content = {
                                Icon(
                                    painter = painterResource(id = closeIcon),
                                    contentDescription = ""
                                )
                            }
                        )
                    }
                }
            }
        }
    )
}