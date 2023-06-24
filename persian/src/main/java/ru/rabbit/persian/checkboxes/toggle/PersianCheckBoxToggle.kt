package ru.rabbit.persian.checkboxes.toggle

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object PersianCheckBoxToggle {

    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        checked: Boolean,
        onCheckedChange: ((Boolean) -> Unit)?,
        colors: CheckboxColors = PersianCheckboxToggleColors.primary(),
    ) {
        Checkbox(
            modifier = modifier,
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = colors
        )
    }
}