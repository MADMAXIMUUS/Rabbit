package ru.rabbit.feature.auth.ui.logIn

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import ru.rabbit.core.util.UiAction
import ru.rabbit.core.util.asString
import ru.rabbit.feature.auth.navigation.Routes
import ru.rabbit.persian.components.TButton
import ru.rabbit.persian.components.TProfileTextFieldTrailing
import ru.rabbit.persian.components.TTopAppBarNavigationOnly
import ru.rabbit.persian.foundation.PersianTheme
import ru.rabbit.persian.foundation.icons

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun LogInRoute(
    snackbarHostState: SnackbarHostState,
    viewModel: LogInViewModel = hiltViewModel(),
    navigateUp: () -> Unit,
    navigate: (route: String) -> Unit,
    onAuthenticate: () -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiAction.ShowSnackbar -> {
                    keyboardController?.hide()
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context),
                        duration = SnackbarDuration.Short
                    )
                }

                is UiAction.Navigate -> {
                    keyboardController?.hide()
                    if (event.route == "") {
                        onAuthenticate()
                    } else {
                        navigate(event.route)
                    }
                }

                is UiAction.NavigateUp -> {
                    navigateUp()
                }

                else -> {}
            }
        }
    }

    LogInScreen(
        state = state,
        navigateUp = navigateUp,
        updateEmail = viewModel::updateEmailValue,
        updatePassword = viewModel::updatePasswordState,
        togglePassword = viewModel::togglePassword,
        forgotPassword = viewModel::forgotPassword,
        onLogIn = viewModel::logIn
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LogInScreen(
    state: LogInScreenState,
    navigateUp: () -> Unit,
    updateEmail: (String) -> Unit,
    updatePassword: (String) -> Unit,
    togglePassword: () -> Unit,
    forgotPassword: () -> Unit,
    onLogIn: () -> Unit
) {
    val annotatedString = buildAnnotatedString {
        val text = "Forgot password?"
        append(text)
        val start = 0
        val end = text.length

        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.None
            ),
            start,
            end
        )
        addStringAnnotation(
            "forgot",
            Routes.LOG_IN_SCREEN_ROUTE,
            start,
            end
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TTopAppBarNavigationOnly(
            navigationIcon = MaterialTheme.icons.arrowBack,
            navigationIconContentDescription = "",
            title = {
                Text(text = "Welcome back")
            },
            onNavigationClick = {
                navigateUp()
            }
        )
        Spacer(modifier = Modifier.weight(0.1f))
        Icon(
            modifier = Modifier
                .size(200.dp),
            painter = MaterialTheme.icons.appLogo,
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = ""
        )
        TProfileTextFieldTrailing(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(ru.rabbit.feature.auth.R.string.email_label),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            isError = state.isEmailError,
            trailingIcon = {
                if (state.isEmailError) {
                    Icon(
                        painter = MaterialTheme.icons.error,
                        contentDescription = ""
                    )
                } else if (state.emailValue.isNotEmpty()) {
                    Icon(
                        painter = MaterialTheme.icons.checkCircle,
                        contentDescription = ""
                    )
                }
            },
            value = state.emailValue,
            supportingText = {
                if (state.isEmailError && state.emailError != null) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = state.emailError),
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
                updateEmail(it)
            }
        )
        TProfileTextFieldTrailing(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(ru.rabbit.feature.auth.R.string.password_label),
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
                            togglePassword()
                        }
                    ) {
                        if (state.passwordShow) {
                            Icon(
                                painter = MaterialTheme.icons.visibility,
                                contentDescription = ""
                            )
                        } else {
                            Icon(
                                painter = MaterialTheme.icons.visibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                    if (state.isPasswordError) {
                        Icon(
                            painter = MaterialTheme.icons.error,
                            contentDescription = ""
                        )
                    } else if (state.passwordValue.isNotEmpty()) {
                        Icon(
                            painter = MaterialTheme.icons.checkCircle,
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
                        text = stringResource(id = state.passwordError),
                        style = MaterialTheme.typography.bodyMedium
                    )
                } else {
                    ClickableText(
                        modifier = Modifier.fillMaxWidth(),
                        text = annotatedString,
                        style = MaterialTheme.typography.bodyMedium,
                        onClick = { offset ->
                            val forgot = annotatedString
                                .getStringAnnotations("forgot", offset, offset).firstOrNull()?.item
                            forgot?.let {
                                forgotPassword()
                            }
                        }
                    )
                }
            },
            onValueChange = {
                updatePassword(it)
            }
        )
        Spacer(modifier = Modifier.weight(0.2f))
        TButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            onClick = {
                onLogIn()
            },
            contentPadding = PaddingValues(
                vertical = 15.dp
            )
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(23.dp),
                    strokeWidth = 3.dp,
                    strokeCap = StrokeCap.Round
                )
            } else {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 18.sp
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Preview(showBackground = true)
@Composable
fun LogInPreview() {
    PersianTheme {
        Surface {
            LogInScreen(
                state = LogInScreenState(),
                navigateUp = {},
                updateEmail = {},
                updatePassword = {},
                togglePassword = {},
                forgotPassword = {},
                onLogIn = {}
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LogInDarkPreview() {
    PersianTheme {
        Surface {
            LogInScreen(
                state = LogInScreenState(),
                navigateUp = {},
                updateEmail = {},
                updatePassword = {},
                togglePassword = {},
                forgotPassword = {},
                onLogIn = {}
            )
        }
    }
}