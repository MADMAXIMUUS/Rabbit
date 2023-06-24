package ru.rabbit.persian.checkboxes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import ru.rabbit.persian.checkboxes.toggle.PersianCheckBoxToggle

object PersianCheckbox {

    @Composable
    fun Primary(
        modifier: Modifier = Modifier,
        text: String,
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        toggleSide: ToggleSide = ToggleSide.LEFT,
        checkboxColors: CheckboxColors = PersianCheckboxColors.primary(),
        checkboxSizes: CheckboxSizes = PersianCheckboxSizes.small(toggleSide)
    ) {
        Row(
            modifier = modifier
                .padding(checkboxSizes.contentPadding)
                .toggleable(
                    value = checked,
                    onValueChange = { onCheckedChange(!checked) },
                    role = Role.Checkbox
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            val toggle = @Composable {
                PersianCheckBoxToggle.Primary(
                    modifier = Modifier
                        .size(checkboxSizes.toggleSize),
                    checked = checked,
                    onCheckedChange = null,
                    colors = checkboxColors.toggleColor
                )
            }

            if (toggleSide == ToggleSide.LEFT) toggle()
            Text(text = text, color = checkboxColors.textColor, style = checkboxSizes.textStyle)
            if (toggleSide == ToggleSide.RIGHT) {
                Spacer(modifier.weight(1f))
                toggle()
            }
        }
    }
}

enum class ToggleSide { LEFT, RIGHT }

@Preview
@Composable
fun CheckboxPreview() {
    MaterialTheme {
        Surface {
            PersianCheckbox.Primary(
                text = "Checkbox",
                checked = false,
                onCheckedChange = {}
            )
        }
    }
}