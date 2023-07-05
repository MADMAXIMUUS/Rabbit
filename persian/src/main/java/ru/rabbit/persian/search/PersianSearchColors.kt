package ru.rabbit.persian.search

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
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.foundation.PersianStatesDisabled

@Immutable
class SearchColors internal constructor(
    //Text Color
    private val unfocusedTextColor: Color,
    private val focusedTextColor: Color,
    private val disabledTextColor: Color,

    //Container Color
    private val unfocusedBackgroundColor: Color,
    private val focusedBackgroundColor: Color,
    private val disabledBackgroundColor: Color,

    //Cursor Color
    private val cursorColor: Color,
    private val textSelectionColors: TextSelectionColors,

    //Placeholder Color
    private val unfocusedPlaceholderColor: Color,
    private val focusedPlaceholderColor: Color,
    private val disabledPlaceholderColor: Color,

    //Leading Icon Color
    private val unfocusedLeadingIconColor: Color,
    private val focusedLeadingIconColor: Color,
    private val disabledLeadingIconColor: Color,

    //Clear Icon Color
    private val unfocusedClearIconColor: Color,
    private val focusedClearIconColor: Color,
    private val disabledClearIconColor: Color
) {

    @Composable
    internal fun textColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledTextColor
            focused -> focusedTextColor

            else -> unfocusedTextColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun containerColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledBackgroundColor
            focused -> focusedBackgroundColor
            else -> unfocusedBackgroundColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun cursorColor(): State<Color> = rememberUpdatedState(cursorColor)

    internal val selectionColors: TextSelectionColors
        @Composable get() = textSelectionColors

    @Composable
    internal fun leadingIconColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        return rememberUpdatedState(
            when {
                !enabled -> disabledLeadingIconColor
                focused -> focusedLeadingIconColor
                else -> unfocusedLeadingIconColor
            }
        )
    }

    @Composable
    internal fun clearIconColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        return rememberUpdatedState(
            when {
                !enabled -> disabledClearIconColor
                focused -> focusedClearIconColor
                else -> unfocusedClearIconColor
            }
        )
    }

    @Composable
    internal fun placeholderColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledPlaceholderColor
            focused -> focusedPlaceholderColor
            else -> unfocusedPlaceholderColor
        }
        return rememberUpdatedState(targetValue)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is SearchColors) return false

        if (focusedTextColor != other.focusedTextColor) return false
        if (unfocusedTextColor != other.unfocusedTextColor) return false
        if (disabledTextColor != other.disabledTextColor) return false
        if (focusedBackgroundColor != other.focusedBackgroundColor) return false
        if (unfocusedBackgroundColor != other.unfocusedBackgroundColor) return false
        if (disabledBackgroundColor != other.disabledBackgroundColor) return false
        if (cursorColor != other.cursorColor) return false
        if (textSelectionColors != other.textSelectionColors) return false
        if (focusedLeadingIconColor != other.focusedLeadingIconColor) return false
        if (unfocusedLeadingIconColor != other.unfocusedLeadingIconColor) return false
        if (disabledLeadingIconColor != other.disabledLeadingIconColor) return false
        if (focusedClearIconColor != other.focusedClearIconColor) return false
        if (unfocusedClearIconColor != other.unfocusedClearIconColor) return false
        if (disabledClearIconColor != other.disabledClearIconColor) return false
        if (focusedPlaceholderColor != other.focusedPlaceholderColor) return false
        if (unfocusedPlaceholderColor != other.unfocusedPlaceholderColor) return false
        if (disabledPlaceholderColor != other.disabledPlaceholderColor) return false
        return true
    }

    override fun hashCode(): Int {
        var result = focusedTextColor.hashCode()
        result = 31 * result + unfocusedTextColor.hashCode()
        result = 31 * result + disabledTextColor.hashCode()
        result = 31 * result + focusedTextColor.hashCode()
        result = 31 * result + cursorColor.hashCode()
        result = 31 * result + textSelectionColors.hashCode()
        result = 31 * result + focusedBackgroundColor.hashCode()
        result = 31 * result + unfocusedBackgroundColor.hashCode()
        result = 31 * result + disabledBackgroundColor.hashCode()
        result = 31 * result + focusedLeadingIconColor.hashCode()
        result = 31 * result + unfocusedLeadingIconColor.hashCode()
        result = 31 * result + disabledLeadingIconColor.hashCode()
        result = 31 * result + focusedClearIconColor.hashCode()
        result = 31 * result + unfocusedClearIconColor.hashCode()
        result = 31 * result + disabledClearIconColor.hashCode()
        result = 31 * result + focusedPlaceholderColor.hashCode()
        result = 31 * result + unfocusedPlaceholderColor.hashCode()
        result = 31 * result + disabledPlaceholderColor.hashCode()
        return result
    }
}

object PersianSearchColors {

    @Composable
    fun primary(
        //Text Color
        unfocusedTextColor: Color = MaterialTheme.colorScheme.onSurface,
        focusedTextColor: Color = MaterialTheme.colorScheme.onSurface,
        disabledTextColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled),

        //Container Color
        unfocusedBackgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
        focusedBackgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
        disabledBackgroundColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianStatesDisabled),

        //Cursor Color
        cursorColor: Color = MaterialTheme.colorScheme.primary,
        textSelectionColors: TextSelectionColors = TextSelectionColors(
            handleColor = MaterialTheme.colorScheme.primary,
            backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
        ),

        //Placeholder Color
        unfocusedPlaceholderColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        focusedPlaceholderColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledPlaceholderColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled),

        //Leading Icon Color
        unfocusedLeadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        focusedLeadingIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledLeadingIconColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled),

        //Clear Icon Color
        unfocusedClearIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        focusedClearIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledClearIconColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = PersianContentStateDisabled)
    ): SearchColors = SearchColors(
        //Text Color
        unfocusedTextColor = unfocusedTextColor,
        focusedTextColor = focusedTextColor,
        disabledTextColor= disabledTextColor,

        //Container Color
        unfocusedBackgroundColor = unfocusedBackgroundColor,
        focusedBackgroundColor = focusedBackgroundColor,
        disabledBackgroundColor = disabledBackgroundColor,

        //Cursor Color
        cursorColor = cursorColor,
        textSelectionColors = textSelectionColors,

        //Placeholder Color
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        focusedPlaceholderColor = focusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,

        //Leading Icon Color
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,

        //Clear Icon Color
        unfocusedClearIconColor = unfocusedClearIconColor,
        focusedClearIconColor = focusedClearIconColor,
        disabledClearIconColor = disabledClearIconColor
    )

}