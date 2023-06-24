package ru.rabbit.persian.radioButtons.toggle

import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object PersianRadioButtonToggle {

    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        checked: Boolean,
        onClick: (() -> Unit)?,
        colors: RadioButtonColors = PersianRadioButtonToggleColors.primary(),
    ) {
        RadioButton(
            modifier = modifier,
            selected = checked,
            onClick = onClick,
            colors = colors
        )
    }
}