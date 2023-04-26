package ru.madmax.composetwitterclone.feature.registry.ui.signUpConfirm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collectLatest
import ru.madmax.composetwitterclone.core.ui.components.TButton
import ru.madmax.composetwitterclone.core.ui.components.TProfileTextField
import ru.madmax.composetwitterclone.core.ui.components.TProfileTextFieldTrailing
import ru.madmax.composetwitterclone.core.ui.components.TTopAppBarNavigationOnly
import ru.madmax.composetwitterclone.feature.registry.R
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.WELCOME_SCREEN
import ru.madmax.composetwitterclone.util.UiAction
import ru.madmax.composetwitterclone.util.asString

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SignUpConfirmScreen(
    name: String,
    email: String,
    date: String,
    navController: NavController,
    snackbarHostState: SnackbarHostState,
    viewModel: SignUpConfirmViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    viewModel.updateNameValue(name)
    viewModel.updateEmailValue(email)
    viewModel.updateDateState(date)

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiAction.ShowSnackbar -> {
                    keyboardController?.hide()
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context),
                        duration = SnackbarDuration.Long
                    )
                }

                is UiAction.Navigate -> {
                    navController.navigate(event.route) {
                        popUpTo(WELCOME_SCREEN) {
                            inclusive = true
                        }
                    }
                    keyboardController?.hide()
                }

                is UiAction.NavigateUp -> {
                    navController.navigateUp()
                }

                else -> {}
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TTopAppBarNavigationOnly(navigationIcon = painterResource(id = ru.madmax.composetwitterclone.core.ui.R.drawable.ic_back_arrow),
            navigationIconContentDescription = "",
            title = {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    painter = painterResource(id = ru.madmax.composetwitterclone.core.ui.R.drawable.app_logo),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = ""
                )
            },
            onNavigationClick = {
                navController.navigateUp()
            })
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = stringResource(R.string.sign_up_main_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        TProfileTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(R.string.name_label),
            readOnly = true,
            value = state.nameValue,
            supportingText = {},
            onValueChange = {
                viewModel.updateNameValue(it)
            }
        )
        TProfileTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(R.string.email_label),
            value = state.emailValue,
            readOnly = true,
            supportingText = {},
            onValueChange = {
                viewModel.updateEmailValue(it)
            }
        )
        TProfileTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(R.string.date_label),
            value = state.dateValue,
            readOnly = true,
            supportingText = {},
            onValueChange = {}
        )
        TProfileTextFieldTrailing(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(R.string.password_label),
            value = state.passwordValue,
            isError = state.isPasswordError,
            trailingIcon = {
                Row(
                    modifier = Modifier
                        .padding(end = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            viewModel.togglePassword()
                        }
                    ) {
                        if (state.passwordShow) {
                            Icon(
                                painterResource(id = R.drawable.ic_visibility),
                                contentDescription = ""
                            )
                        } else {
                            Icon(
                                painterResource(id = R.drawable.ic_visibility_off),
                                contentDescription = ""
                            )
                        }
                    }
                    if (state.isPasswordError) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_error),
                            contentDescription = ""
                        )
                    } else if (state.passwordValue.isNotEmpty()) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_check),
                            contentDescription = ""
                        )
                    }
                }
            },
            visualTransformation = if (state.passwordShow) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            supportingText = {
                if (state.isPasswordError && state.passwordError != null) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = state.passwordError!!),
                        style = MaterialTheme.typography.bodyMedium
                    )
                } else {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            },
            onValueChange = {
                viewModel.updatePasswordState(it)
            }
        )
        Spacer(
            modifier = Modifier
                .weight(0.2f)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            style = MaterialTheme.typography.bodySmall,
            text = stringResource(id = R.string.sign_up_message)
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        TButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            onClick = {
                viewModel.signUp()
            },
            contentPadding = PaddingValues(
                vertical = 15.dp
            )
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(22.dp),
                    strokeWidth = 3.dp,
                    strokeCap = StrokeCap.Round
                )
            } else {
                Text(
                    text = "Sign up",
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 16.sp
                )
            }
        }
        Spacer(
            modifier = Modifier
                .weight(0.5f)
        )
    }
}