package ru.rabbit.feature.auth.ui.signUp

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import kotlinx.coroutines.flow.collectLatest
import ru.rabbit.core.util.UiAction
import ru.rabbit.core.util.asString
import ru.rabbit.persian.components.TButton
import ru.rabbit.persian.components.TProfileTextFieldTrailing
import ru.rabbit.persian.components.TTopAppBarNavigationOnly
import ru.rabbit.persian.foundation.PersianTheme
import ru.rabbit.persian.foundation.icons
import java.time.LocalDate

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun SignUpRoute(
    snackbarHostState: SnackbarHostState,
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateUp: () -> Unit,
    navigateToNextScreen: (route: String) -> Unit
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
                    navigateToNextScreen(event.route)
                }

                is UiAction.NavigateUp -> {
                    navigateUp()
                }

                else -> {}
            }
        }
    }

    SignUpScreen(
        state = state,
        navigateUp = navigateUp,
        updateName = viewModel::updateNameValue,
        updateEmail = viewModel::updateEmailValue,
        updateDate = viewModel::updateDateState,
        updatePassword = viewModel::updatePasswordState,
        togglePassword = viewModel::togglePassword,
        onSignUp = viewModel::signUp
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SignUpScreen(
    state: SignUpScreenState,
    navigateUp: () -> Unit,
    updateName: (String) -> Unit,
    updateEmail: (String) -> Unit,
    updateDate: (LocalDate) -> Unit,
    updatePassword: (String) -> Unit,
    togglePassword: () -> Unit,
    onSignUp: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }


    val source = remember {
        MutableInteractionSource()
    }

    if (source.collectIsPressedAsState().value) {
        state.calendarState.show()
    }

    CalendarDialog(
        state = state.calendarState,
        config = CalendarConfig(
            monthSelection = true, yearSelection = true
        ),
        selection = CalendarSelection.Date(
            selectedDate = state.localDateValue
        ) { date ->
            updateDate(date)
            state.calendarState.hide()
        },
    )

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
                Text(text = stringResource(ru.rabbit.feature.auth.R.string.sign_up_main_title))
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
            label = stringResource(ru.rabbit.feature.auth.R.string.name_label),
            isError = state.isNameError,
            trailingIcon = {
                if (state.isNameError) {
                    Icon(
                        painter = MaterialTheme.icons.error,
                        contentDescription = ""
                    )
                } else if (state.nameValue.isNotEmpty()) {
                    Icon(
                        painter = MaterialTheme.icons.checkCircle,
                        contentDescription = ""
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
            ),
            value = state.nameValue,
            supportingText = {
                if (state.isNameError && state.nameError != null) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = state.nameError),
                        style = MaterialTheme.typography.bodyMedium
                    )
                } else {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "${state.nameValue.length}/50",
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            },
            onValueChange = {
                updateName(it)
            })
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
                .padding(horizontal = 40.dp)
                .focusRequester(focusRequester)
                .onFocusChanged {
                    if (it.isFocused) {
                        state.calendarState.show()
                    }
                },
            label = stringResource(ru.rabbit.feature.auth.R.string.date_label),
            value = state.dateValue,
            interactionSource = source,
            readOnly = true,
            isError = state.isDateError,
            trailingIcon = {
                if (state.isDateError) {
                    Icon(
                        painter = MaterialTheme.icons.error,
                        contentDescription = ""
                    )
                } else if (state.dateValue.isNotEmpty()) {
                    Icon(
                        painter = MaterialTheme.icons.checkCircle,
                        contentDescription = ""
                    )
                }
            },
            supportingText = {
                if (state.isDateError && state.dateError != null) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = state.dateError),
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
            onValueChange = {}
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
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "",
                        style = MaterialTheme.typography.bodyMedium
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
                onSignUp()
            },
            contentPadding = PaddingValues(
                vertical = 15.dp
            )
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    //color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 3.dp,
                    strokeCap = StrokeCap.Round
                )
            } else {
                Text(
                    text = stringResource(ru.rabbit.feature.auth.R.string.create_account),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    PersianTheme {
        Surface {
            SignUpScreen(
                state = SignUpScreenState(),
                navigateUp = {},
                updateName = {},
                updateEmail = {},
                updateDate = {},
                updatePassword = {},
                togglePassword = {},
                onSignUp = {}
            )
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SignUpDarkPreview() {
    PersianTheme {
        Surface {
            SignUpScreen(
                state = SignUpScreenState(),
                navigateUp = {},
                updateName = {},
                updateEmail = {},
                updateDate = {},
                updatePassword = {},
                togglePassword = {},
                onSignUp = {}
            )
        }
    }
}