package ru.rabbit.persian.radioButtons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import ru.rabbit.persian.radioButtons.toggle.PersianRadioButtonToggle

object PersianRadioButton {

    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        text: String,
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        radioButtonColors: RadioButtonColors = PersianRadioButtonColors.primary(),
        radioButtonSizes: RadioButtonSizes = PersianRadioButtonSizes.small()
    ) {
        Row(
            modifier = modifier
                .padding(radioButtonSizes.contentPadding)
                .toggleable(
                    value = checked,
                    onValueChange = { onCheckedChange(!checked) },
                    role = Role.RadioButton
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            PersianRadioButtonToggle.Primary(
                modifier = Modifier
                    .size(radioButtonSizes.toggleSize),
                checked = checked,
                onClick = null,
                colors = radioButtonColors.toggleColor
            )
            Text(
                text = text,
                color = radioButtonColors.textColor,
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
                text = "Radio Button",
                checked = false,
                onCheckedChange = {}
            )
        }
    }
}