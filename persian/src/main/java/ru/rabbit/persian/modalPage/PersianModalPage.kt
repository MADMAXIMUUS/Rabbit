package ru.rabbit.persian.modalPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ru.rabbit.persian.topAppBar.PersianTopAppBar

object PersianModalPage {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DynamicHeight(
        modifier: Modifier = Modifier,
        onDismissRequest: () -> Unit,
        sheetState: SheetState = rememberModalBottomSheetState(),
        shape: Shape = MaterialTheme.shapes.large.copy(
            bottomEnd = CornerSize(0),
            bottomStart = CornerSize(0)
        ),
        backgroundColor: Color = MaterialTheme.colorScheme.surface,
        title: String,
        actionTitle: String,
        onActionClick: () -> Unit,
        content: @Composable ColumnScope.() -> Unit
    ) {
        ModalBottomSheet(
            modifier = modifier,
            onDismissRequest = onDismissRequest,
            containerColor = backgroundColor,
            sheetState = sheetState,
            tonalElevation = 0.dp,
            shape = shape,
            dragHandle = null,
            content = {
                PersianTopAppBar.Primary(
                    left = {
                        Close(
                            onClick = {
                                onDismissRequest()
                            }
                        )
                    },
                    middle = {
                        Title(text = title)
                    },
                    right = {
                        Button(text = actionTitle, onClick = onActionClick)
                    },
                    actionsCount = 1
                )
                content()
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Extended(
        modifier: Modifier = Modifier,
        onDismissRequest: () -> Unit,
        sheetState: SheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        ),
        shape: Shape = MaterialTheme.shapes.large.copy(
            bottomEnd = CornerSize(0),
            bottomStart = CornerSize(0)
        ),
        backgroundColor: Color = MaterialTheme.colorScheme.surface,
        title: String,
        actionTitle: String,
        onActionClick: () -> Unit,
        content: @Composable ColumnScope.() -> Unit
    ) {
        ModalBottomSheet(
            modifier = modifier,
            onDismissRequest = onDismissRequest,
            containerColor = backgroundColor,
            sheetState = sheetState,
            tonalElevation = 0.dp,
            shape = shape,
            dragHandle = null,
            content = {
                PersianTopAppBar.Primary(
                    left = {
                        Close(
                            onClick = {
                                onDismissRequest()
                            }
                        )
                    },
                    middle = {
                        Title(text = title)
                    },
                    right = {
                        Button(text = actionTitle, onClick = onActionClick)
                    },
                    actionsCount = 1
                )
                content()
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FullScreen(
        onDismissRequest: () -> Unit,
        title: String,
        actionTitle: String,
        onActionClick: () -> Unit,
        content: @Composable () -> Unit
    ) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                decorFitsSystemWindows = false,
                usePlatformDefaultWidth = false
            ),
            content = {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    tonalElevation = 0.dp,
                    shadowElevation = 0.dp
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        PersianTopAppBar.Primary(
                            left = {
                                Close(
                                    onClick = {
                                        onDismissRequest()
                                    }
                                )
                            },
                            middle = {
                                Title(text = title)
                            },
                            right = {
                                Button(text = actionTitle, onClick = onActionClick)
                            },
                            actionsCount = 1
                        )
                        content()
                    }
                }

            }
        )
    }
}