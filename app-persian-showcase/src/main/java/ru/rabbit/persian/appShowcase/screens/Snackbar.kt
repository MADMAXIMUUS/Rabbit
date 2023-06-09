package ru.rabbit.persian.appShowcase.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.rabbit.persian.appShowcase.componets.SampleScaffold
import ru.rabbit.persian.buttons.PersianButton
import ru.rabbit.persian.buttons.PersianButtonSizes
import ru.rabbit.persian.foundation.icons
import ru.rabbit.persian.foundation.spacing
import ru.rabbit.persian.snackbar.PersianSnackbarVisuals

object Snackbar : Screen {

    override val name: String = "Snackbar"

    override val navigation: String = "snackbar"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(navController: NavController?) {
        val snackbarHostState = remember { SnackbarHostState() }
        val coroutineScope = rememberCoroutineScope()
        SampleScaffold(
            title = name,
            onBackClick = {
                navController?.navigateUp()
            },
            snackbarHostState = snackbarHostState,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium)
            ) {
                PersianButton.Primary(
                    text = "Only text",
                    size = PersianButtonSizes.large()
                ) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            PersianSnackbarVisuals(
                                message = "Simple Snackbar",
                                duration = SnackbarDuration.Short
                            )
                        )
                    }
                }
                PersianButton.Primary(
                    text = "With Action Button",
                    size = PersianButtonSizes.large()
                ) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            PersianSnackbarVisuals(
                                message = "Simple Snackbar",
                                duration = SnackbarDuration.Short,
                                right = {
                                    Action(
                                        text = "Action",
                                        onClick = {}
                                    )
                                }
                            )
                        )
                    }
                }
                PersianButton.Primary(
                    text = "With Close Button",
                    size = PersianButtonSizes.large()
                ) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            PersianSnackbarVisuals(
                                message = "Simple Snackbar",
                                duration = SnackbarDuration.Short,
                                right = {
                                    Close(onClick = {})
                                }
                            )
                        )
                    }
                }
                PersianButton.Primary(
                    text = "With icon",
                    size = PersianButtonSizes.large()
                ) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            PersianSnackbarVisuals(
                                message = "Simple Snackbar",
                                duration = SnackbarDuration.Short,
                                left = {
                                    Icon24(
                                        icon = MaterialTheme.icons.wifiOff,
                                        contentDescription = ""
                                    )
                                }
                            )
                        )
                    }
                }
                PersianButton.Primary(
                    text = "With image",
                    size = PersianButtonSizes.large()
                ) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            PersianSnackbarVisuals(
                                message = "Simple Snackbar",
                                duration = SnackbarDuration.Short,
                                left = {
                                    Image(
                                        image = "https://loremflickr.com/320/240",
                                        contentDescription = ""
                                    )
                                }
                            )
                        )
                    }
                }
                PersianButton.Primary(
                    text = "With counter",
                    size = PersianButtonSizes.large()
                ) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            PersianSnackbarVisuals(
                                message = "Simple Snackbar",
                                duration = SnackbarDuration.Short,
                                left = {
                                    Progress(
                                        progress = 0.5f
                                    )
                                }
                            )
                        )
                    }
                }
            }
        }
    }
}