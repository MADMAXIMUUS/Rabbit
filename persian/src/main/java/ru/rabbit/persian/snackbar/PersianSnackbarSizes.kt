package ru.rabbit.persian.snackbar

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle

@Immutable
data class SnackbarSizes(
    val cornerRadius: Shape,
    val textStyle: TextStyle,

    )