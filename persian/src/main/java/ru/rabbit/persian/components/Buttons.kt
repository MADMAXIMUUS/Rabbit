package ru.rabbit.persian.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.rabbit.persian.foundation.PersianTheme

@Composable
fun TOutlineButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    border: BorderStroke = ButtonDefaults.outlinedButtonBorder,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        onClick = { onClick() },
        contentPadding = contentPadding,
        border = border,
        colors = colors,
        enabled = enabled
    ) {
        content()
    }
}

@Composable
fun TOutlineButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    border: BorderStroke = ButtonDefaults.outlinedButtonBorder,
    text: @Composable () -> Unit,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    TOutlineButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        border = border,
        contentPadding = contentPadding
    ) {
        TButtonContent(text, leadingIcon)
    }
}

@Composable
fun TButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

@Composable
fun TButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    TButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
    ) {
        TButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
fun TTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    content: @Composable RowScope.() -> Unit,
) {
    TextButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        content = content,
    )
}

@Composable
fun TTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    TTextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors
    ) {
        TButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
private fun TButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            leadingIcon()
        }
    }
    Box(
        Modifier
            .padding(
                start = if (leadingIcon != null) {
                    ButtonDefaults.IconSpacing
                } else {
                    0.dp
                },
            ),
    ) {
        text()
    }
}

@Preview(showBackground = true)
@Composable
fun TOutlineButtonPreview() {
    PersianTheme {
        Surface {
            TOutlineButton(
                onClick = {}) {
                Text("Я текст")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TButtonPreview() {
    PersianTheme {
        Surface {
            TButton(onClick = {}) {
                Text("Я текст")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TTextButtonPreview() {
    PersianTheme {
        Surface {
            TTextButton(onClick = { }) {
                Text("Я текст")
            }
        }
    }
}