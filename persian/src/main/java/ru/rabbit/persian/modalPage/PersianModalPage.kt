package ru.rabbit.persian.modalPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
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
        content: @Composable BoxScope.() -> Unit
    ) {
        ModalBottomSheet(
            modifier = modifier
                .statusBarsPadding(),
            onDismissRequest = onDismissRequest,
            containerColor = backgroundColor,
            sheetState = sheetState,
            tonalElevation = 0.dp,
            shape = shape,
            dragHandle = null,
            windowInsets = WindowInsets(0, 0, 0, 0),
            content = {
                Scaffold(
                    modifier = Modifier.fillMaxWidth(),
                    topBar = {
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
                                Button(
                                    text = actionTitle, onClick = onActionClick
                                )
                            },
                            actionItemsCount = 1
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(it)
                    )
                    {
                        content()
                    }
                }
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
        content: @Composable BoxScope.() -> Unit
    ) {
        ModalBottomSheet(
            modifier = modifier
                .statusBarsPadding(),
            onDismissRequest = onDismissRequest,
            containerColor = backgroundColor,
            sheetState = sheetState,
            tonalElevation = 0.dp,
            shape = shape,
            dragHandle = null,
            windowInsets = WindowInsets(0, 0, 0, 0),
            content = {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
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
                                Button(
                                    text = actionTitle, onClick = onActionClick
                                )
                            },
                            actionItemsCount = 1
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(it)
                    )
                    {
                        content()
                    }
                }
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
        content: @Composable BoxScope.() -> Unit
    ) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                decorFitsSystemWindows = false,
                usePlatformDefaultWidth = false
            ),
            content = {
                val dialogWindowProvider = (LocalView.current.parent as DialogWindowProvider)
                dialogWindowProvider.window.setDimAmount(0f)
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
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
                                Button(
                                    text = actionTitle, onClick = onActionClick
                                )
                            },
                            actionItemsCount = 1
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    )
                    {
                        content()
                    }
                }
            }
        )
    }
}