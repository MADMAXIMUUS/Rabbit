package ru.rabbit.persian.textAreas

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.foundation.PersianStatesDisabled
import ru.rabbit.persian.foundation.icons

@Immutable
class InputColors internal constructor(

    //State Icon
    private val errorStateIcon: Painter,
    private val successStateIcon: Painter,

    //State Icon Colors
    private val errorStateIconColor: Color,
    private val successStateIconColor: Color,

    //Text Colors
    private val focusedTextColor: Color,
    private val unfocusedTextColor: Color,
    private val disabledTextColor: Color,
    private val errorTextColor: Color,
    private val successTextColor: Color,

    //Container Colors
    private val focusedContainerColor: Color,
    private val unfocusedContainerColor: Color,
    private val disabledContainerColor: Color,
    private val errorContainerColor: Color,
    private val successContainerColor: Color,

    //Cursor Colors
    private val cursorColor: Color,
    private val errorCursorColor: Color,
    private val successCursorColor: Color,
    private val textSelectionColors: TextSelectionColors,

    //Indicator Colors
    private val focusedIndicatorColor: Color,
    private val unfocusedIndicatorColor: Color,
    private val disabledIndicatorColor: Color,
    private val errorIndicatorColor: Color,
    private val successIndicatorColor: Color,

    //Leading Icon Colors
    private val focusedLeadingIconColor: Color,
    private val unfocusedLeadingIconColor: Color,
    private val disabledLeadingIconColor: Color,
    private val errorLeadingIconColor: Color,
    private val successLeadingIconColor: Color,

    //Placeholder Colors
    private val focusedPlaceholderColor: Color,
    private val unfocusedPlaceholderColor: Color,
    private val disabledPlaceholderColor: Color,
    private val errorPlaceholderColor: Color,
) {
    @Composable
    internal fun stateIcon(
        enabled: Boolean,
        isSuccess: Boolean,
        isError: Boolean
    ): State<Painter?> {

        val targetValue = when {
            !enabled -> null
            isError -> errorStateIcon
            isSuccess -> successStateIcon

            else -> null
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun stateIconColor(
        enabled: Boolean,
        isSuccess: Boolean,
        isError: Boolean
    ): State<Color> {

        val targetValue = when {
            !enabled -> Color.Transparent
            isError -> errorStateIconColor
            isSuccess -> successStateIconColor

            else -> Color.Transparent
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun textColor(
        enabled: Boolean,
        isSuccess: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledTextColor
            isError -> errorTextColor
            isSuccess -> successTextColor
            focused -> focusedTextColor

            else -> unfocusedTextColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun containerColor(
        enabled: Boolean,
        isSuccess: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledContainerColor
            isError -> errorContainerColor
            isSuccess -> successContainerColor
            focused -> focusedContainerColor
            else -> unfocusedContainerColor
        }
        return animateColorAsState(targetValue, tween(durationMillis = ANIMATION_DURATION))
    }

    @Composable
    internal fun cursorColor(isError: Boolean, isSuccess: Boolean): State<Color> {
        val targetValue = when {
            isError -> errorCursorColor
            isSuccess -> successCursorColor
            else -> cursorColor
        }
        return rememberUpdatedState(targetValue)
    }

    internal val selectionColors: TextSelectionColors
        @Composable get() = textSelectionColors

    @Composable
    internal fun indicatorColor(
        enabled: Boolean,
        isSuccess: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledIndicatorColor
            isError -> errorIndicatorColor
            isSuccess -> successIndicatorColor
            focused -> focusedIndicatorColor
            else -> unfocusedIndicatorColor
        }
        return if (enabled) {
            animateColorAsState(targetValue, tween(durationMillis = ANIMATION_DURATION))
        } else {
            rememberUpdatedState(targetValue)
        }
    }

    @Composable
    internal fun leadingIconColor(
        enabled: Boolean,
        isSuccess: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        return rememberUpdatedState(
            when {
                !enabled -> disabledLeadingIconColor
                isError -> errorLeadingIconColor
                isSuccess -> successLeadingIconColor
                focused -> focusedLeadingIconColor
                else -> unfocusedLeadingIconColor
            }
        )
    }

    @Composable
    internal fun placeholderColor(
        enabled: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledPlaceholderColor
            isError -> errorPlaceholderColor
            focused -> focusedPlaceholderColor
            else -> unfocusedPlaceholderColor
        }
        return rememberUpdatedState(targetValue)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is InputColors) return false

        if (focusedTextColor != other.focusedTextColor) return false
        if (unfocusedTextColor != other.unfocusedTextColor) return false
        if (disabledTextColor != other.disabledTextColor) return false
        if (errorTextColor != other.errorTextColor) return false
        if (focusedContainerColor != other.focusedContainerColor) return false
        if (unfocusedContainerColor != other.unfocusedContainerColor) return false
        if (disabledContainerColor != other.disabledContainerColor) return false
        if (errorContainerColor != other.errorContainerColor) return false
        if (cursorColor != other.cursorColor) return false
        if (errorCursorColor != other.errorCursorColor) return false
        if (textSelectionColors != other.textSelectionColors) return false
        if (focusedIndicatorColor != other.focusedIndicatorColor) return false
        if (unfocusedIndicatorColor != other.unfocusedIndicatorColor) return false
        if (disabledIndicatorColor != other.disabledIndicatorColor) return false
        if (errorIndicatorColor != other.errorIndicatorColor) return false
        if (focusedLeadingIconColor != other.focusedLeadingIconColor) return false
        if (unfocusedLeadingIconColor != other.unfocusedLeadingIconColor) return false
        if (disabledLeadingIconColor != other.disabledLeadingIconColor) return false
        if (errorLeadingIconColor != other.errorLeadingIconColor) return false
        if (focusedPlaceholderColor != other.focusedPlaceholderColor) return false
        if (unfocusedPlaceholderColor != other.unfocusedPlaceholderColor) return false
        if (disabledPlaceholderColor != other.disabledPlaceholderColor) return false
        if (errorPlaceholderColor != other.errorPlaceholderColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = focusedTextColor.hashCode()
        result = 31 * result + unfocusedTextColor.hashCode()
        result = 31 * result + disabledTextColor.hashCode()
        result = 31 * result + errorTextColor.hashCode()
        result = 31 * result + focusedContainerColor.hashCode()
        result = 31 * result + unfocusedContainerColor.hashCode()
        result = 31 * result + disabledContainerColor.hashCode()
        result = 31 * result + errorContainerColor.hashCode()
        result = 31 * result + cursorColor.hashCode()
        result = 31 * result + errorCursorColor.hashCode()
        result = 31 * result + textSelectionColors.hashCode()
        result = 31 * result + focusedIndicatorColor.hashCode()
        result = 31 * result + unfocusedIndicatorColor.hashCode()
        result = 31 * result + disabledIndicatorColor.hashCode()
        result = 31 * result + errorIndicatorColor.hashCode()
        result = 31 * result + focusedLeadingIconColor.hashCode()
        result = 31 * result + unfocusedLeadingIconColor.hashCode()
        result = 31 * result + disabledLeadingIconColor.hashCode()
        result = 31 * result + errorLeadingIconColor.hashCode()
        result = 31 * result + focusedPlaceholderColor.hashCode()
        result = 31 * result + unfocusedPlaceholderColor.hashCode()
        result = 31 * result + disabledPlaceholderColor.hashCode()
        return result
    }

    private companion object {
        const val ANIMATION_DURATION = 150
    }
}

object PersianInputColors {

    @Composable
    fun primary(
        //State Icon
        errorStateIcon: Painter = MaterialTheme.icons.error,
        successStateIcon: Painter = MaterialTheme.icons.checkCircle,

        //State Icon Colors
        errorStateIconColor: Color = MaterialTheme.colorScheme.error,
        successStateIconColor: Color = MaterialTheme.colorScheme.primary,

        //Text Colors
        focusedTextColor: Color = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor: Color = MaterialTheme.colorScheme.onSurface,
        disabledTextColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled),
        errorTextColor: Color = MaterialTheme.colorScheme.error,
        successTextColor: Color = MaterialTheme.colorScheme.onSurface,

        //Container Colors
        focusedContainerColor: Color = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor: Color = MaterialTheme.colorScheme.surface,
        disabledContainerColor: Color = MaterialTheme.colorScheme.surface,
        errorContainerColor: Color = MaterialTheme.colorScheme.errorContainer
            .copy(alpha = PersianContentStateDisabled),
        successContainerColor: Color = MaterialTheme.colorScheme.primaryContainer
            .copy(alpha = PersianContentStateDisabled),

        //Cursor Colors
        cursorColor: Color = MaterialTheme.colorScheme.primary,
        errorCursorColor: Color = MaterialTheme.colorScheme.error,
        successCursorColor: Color = MaterialTheme.colorScheme.primary,
        textSelectionColors: TextSelectionColors = TextSelectionColors(
            handleColor = MaterialTheme.colorScheme.primary,
            backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
        ),

        //Indicator Colors
        focusedIndicatorColor: Color = MaterialTheme.colorScheme.primary,
        unfocusedIndicatorColor: Color = MaterialTheme.colorScheme.outline,
        disabledIndicatorColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),
        errorIndicatorColor: Color = MaterialTheme.colorScheme.error,
        successIndicatorColor: Color = MaterialTheme.colorScheme.primary,

        //Leading Icon Colors
        focusedLeadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedLeadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledLeadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
            .copy(alpha = PersianContentStateDisabled),
        errorLeadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        successLeadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,

        //Placeholder Colors
        focusedPlaceholderColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedPlaceholderColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledPlaceholderColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled),
        errorPlaceholderColor: Color = MaterialTheme.colorScheme.error,
    ): InputColors =
        InputColors(
            //State Icon
            errorStateIcon = errorStateIcon,
            successStateIcon = successStateIcon,

            //State Icon Colors
            errorStateIconColor = errorStateIconColor,
            successStateIconColor = successStateIconColor,

            //Text Colors
            focusedTextColor = focusedTextColor,
            unfocusedTextColor = unfocusedTextColor,
            disabledTextColor = disabledTextColor,
            errorTextColor = errorTextColor,
            successTextColor = successTextColor,

            //Container Colors
            focusedContainerColor = focusedContainerColor,
            unfocusedContainerColor = unfocusedContainerColor,
            disabledContainerColor = disabledContainerColor,
            errorContainerColor = errorContainerColor,
            successContainerColor = successContainerColor,

            //Cursor Colors
            cursorColor = cursorColor,
            errorCursorColor = errorCursorColor,
            successCursorColor = successCursorColor,
            textSelectionColors = textSelectionColors,

            //Indicator Colors
            focusedIndicatorColor = focusedIndicatorColor,
            unfocusedIndicatorColor = unfocusedIndicatorColor,
            disabledIndicatorColor = disabledIndicatorColor,
            errorIndicatorColor = errorIndicatorColor,
            successIndicatorColor = successIndicatorColor,

            //Leading Icon Colors
            focusedLeadingIconColor = focusedLeadingIconColor,
            unfocusedLeadingIconColor = unfocusedLeadingIconColor,
            disabledLeadingIconColor = disabledLeadingIconColor,
            errorLeadingIconColor = errorLeadingIconColor,
            successLeadingIconColor = successLeadingIconColor,

            //Placeholder Colors
            focusedPlaceholderColor = focusedPlaceholderColor,
            unfocusedPlaceholderColor = unfocusedPlaceholderColor,
            disabledPlaceholderColor = disabledPlaceholderColor,
            errorPlaceholderColor = errorPlaceholderColor
        )
}