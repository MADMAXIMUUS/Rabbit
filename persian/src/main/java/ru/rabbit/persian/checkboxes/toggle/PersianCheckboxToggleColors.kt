package ru.rabbit.persian.checkboxes.toggle

import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianStatesDisabled

object PersianCheckboxToggleColors {

    @Composable
    fun primary(
        checkedColor: Color = MaterialTheme.colorScheme.primary,
        uncheckedColor: Color = MaterialTheme.colorScheme.outline,
        checkmarkColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledCheckedColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianStatesDisabled),
        disabledUncheckedColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianStatesDisabled),
        disabledIndeterminateColor: Color = disabledCheckedColor
    ) = CheckboxDefaults
        .colors(
            checkedColor = checkedColor,
            uncheckedColor = uncheckedColor,
            checkmarkColor = checkmarkColor,
            disabledCheckedColor = disabledCheckedColor,
            disabledUncheckedColor = disabledUncheckedColor,
            disabledIndeterminateColor = disabledIndeterminateColor
        )
}