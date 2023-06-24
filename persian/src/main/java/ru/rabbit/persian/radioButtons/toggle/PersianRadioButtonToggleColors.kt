package ru.rabbit.persian.radioButtons.toggle

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.rabbit.persian.foundation.PersianStatesDisabled

object PersianRadioButtonToggleColors {

    @Composable
    fun primary(
        selectedColor: Color = MaterialTheme.colorScheme.primary,
        unselectedColor: Color = MaterialTheme.colorScheme.outline,
        disabledSelectedColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianStatesDisabled),
        disabledUnselectedColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(PersianStatesDisabled)
    ) = RadioButtonDefaults
        .colors(
            selectedColor = selectedColor,
            unselectedColor = unselectedColor,
            disabledSelectedColor = disabledSelectedColor,
            disabledUnselectedColor = disabledUnselectedColor,
        )
}