package ru.rabbit.persian.radioButtons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import ru.rabbit.persian.foundation.PersianContentStateDisabled
import ru.rabbit.persian.radioButtons.toggle.PersianRadioButtonToggle

object PersianRadioButton {

    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        text: String,
        checked: Boolean,
        enabled: Boolean = true,
        onCheckedChange: (Boolean) -> Unit,
        radioButtonColors: RadioButtonColors = PersianRadioButtonColors.primary(),
        radioButtonSizes: RadioButtonSizes = PersianRadioButtonSizes.small()
    ) {
        val textColor = if (enabled) radioButtonColors.textColor
        else MaterialTheme.colorScheme.onSurface.copy(alpha = PersianContentStateDisabled)
        Row(
            modifier = modifier
                .selectable(
                    enabled = enabled,
                    selected = checked,
                    onClick = { onCheckedChange(!checked) },
                    role = Role.RadioButton
                )
                .padding(radioButtonSizes.contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            PersianRadioButtonToggle.Primary(
                modifier = Modifier
                    .size(radioButtonSizes.toggleSize),
                checked = checked,
                enabled = enabled,
                onClick = null,
                colors = radioButtonColors.toggleColor
            )
            Text(
                modifier = Modifier.weight(1f),
                text = text,
                color = textColor,
                style = radioButtonSizes.textStyle
            )
        }
    }
}

@Preview
@Composable
fun CheckboxPreview() {
    MaterialTheme {
        Surface {
            PersianRadioButton.Primary(
                modifier = Modifier.fillMaxWidth(),
                text = "Radio Button",
                checked = false,
                onCheckedChange = {}
            )
        }
    }
}