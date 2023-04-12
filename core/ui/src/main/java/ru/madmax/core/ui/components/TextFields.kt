package ru.madmax.core.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TProfileTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    readOnly: Boolean = false,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        disabledBorderColor = MaterialTheme.colorScheme.onBackground
    ),
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    prefix: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        colors = colors,
        supportingText = supportingText,
        isError = isError,
        singleLine = singleLine,
        interactionSource = interactionSource,
        readOnly = readOnly,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = {
            if (trailingIcon != null) {
                trailingIcon()
            }
        },
        leadingIcon = {
            if (leadingIcon != null) {
                leadingIcon()
            }
        },
        prefix = prefix,
        label = {
            Text(text = label)
        },
        onValueChange = {
            onValueChange(it)
        }
    )
}

@Composable
fun TProfileTextFieldLeading(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    readOnly: Boolean = false,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        disabledBorderColor = MaterialTheme.colorScheme.onBackground
    ),
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    prefix: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        colors = colors,
        supportingText = supportingText,
        isError = isError,
        singleLine = singleLine,
        interactionSource = interactionSource,
        readOnly = readOnly,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        leadingIcon = {
            if (leadingIcon != null) {
                leadingIcon()
            }
        },
        prefix = prefix,
        label = {
            Text(text = label)
        },
        onValueChange = {
            onValueChange(it)
        }
    )
}

@Composable
fun TProfileTextFieldTrailing(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    readOnly: Boolean = false,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        disabledBorderColor = MaterialTheme.colorScheme.onBackground
    ),
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    prefix: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        colors = colors,
        supportingText = supportingText,
        isError = isError,
        singleLine = singleLine,
        interactionSource = interactionSource,
        readOnly = readOnly,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = {
            if (trailingIcon != null) {
                trailingIcon()
            }
        },
        prefix = prefix,
        label = {
            Text(text = label)
        },
        onValueChange = {
            onValueChange(it)
        }
    )
}

@Composable
fun TProfileTextField(
    modifier: Modifier = Modifier,
    label: String,
    readOnly: Boolean = false,
    value: String,
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    prefix: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        colors = colors,
        readOnly = readOnly,
        interactionSource = interactionSource,
        supportingText = supportingText,
        isError = isError,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        prefix = prefix,
        label = {
            Text(text = label)
        },
        onValueChange = {
            onValueChange(it)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    TProfileTextField(
        modifier = Modifier.padding(40.dp),
        label = "Label",
        prefix = { Text("@") },
        value = "Value",
        onValueChange = {}
    )
}

