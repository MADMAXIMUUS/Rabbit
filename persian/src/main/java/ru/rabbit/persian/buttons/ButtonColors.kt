package ru.rabbit.persian.buttons

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianStatesDisabled

object PersianButtonColors {

    @Composable
    fun Primary(
        style: PersianButtonStyle,
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.primary
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.primary
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = when (style) {
        PersianButtonStyle.Fill -> ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )

        PersianButtonStyle.Outlined -> ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = containerColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = disabledContainerColor
        )

        PersianButtonStyle.Text -> ButtonDefaults.textButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )
    }


    @Composable
    fun Secondary(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun Tertiary(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun Negative(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun Neutral(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

}