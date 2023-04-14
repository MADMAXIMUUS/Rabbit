package ru.madmax.composetwitterclone.feature.registry.ui.signUpMain

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import ru.madmax.composetwitterclone.core.ui.R
import ru.madmax.composetwitterclone.core.ui.components.TButton
import ru.madmax.composetwitterclone.core.ui.components.TProfileTextFieldTrailing
import ru.madmax.composetwitterclone.core.ui.components.TTopAppBarNavigationOnly

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SignUpMainScreen(
    navController: NavController,
    viewModel: SignUpMainViewModel = hiltViewModel()
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val state by viewModel.uiState.collectAsState()

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
            viewModel.updateDateState(date)
            state.calendarState.hide()
        },
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TTopAppBarNavigationOnly(navigationIcon = painterResource(id = R.drawable.ic_back_arrow),
            navigationIconContentDescription = "",
            title = {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    painter = painterResource(id = R.drawable.app_logo),
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
            text = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.sign_up_main_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        TProfileTextFieldTrailing(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.name_label),
            isError = state.isNameError,
            trailingIcon = {
                if (state.isNameError) {
                    Icon(
                        painter = painterResource(id = ru.madmax.composetwitterclone.feature.registry.R.drawable.ic_error),
                        contentDescription = ""
                    )
                } else if (state.nameValue.isNotEmpty()) {
                    Icon(
                        painter = painterResource(id = ru.madmax.composetwitterclone.feature.registry.R.drawable.ic_check),
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
                        text = stringResource(id = state.nameError!!),
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
                viewModel.updateNameValue(it)
            })
        TProfileTextFieldTrailing(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            label = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.email_label),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            isError = state.isEmailError,
            trailingIcon = {
                if (state.isEmailError) {
                    Icon(
                        painter = painterResource(id = ru.madmax.composetwitterclone.feature.registry.R.drawable.ic_error),
                        contentDescription = ""
                    )
                } else if (state.emailValue.isNotEmpty()) {
                    Icon(
                        painter = painterResource(id = ru.madmax.composetwitterclone.feature.registry.R.drawable.ic_check),
                        contentDescription = ""
                    )
                }
            },
            value = state.emailValue,
            supportingText = {
                if (state.isEmailError && state.emailError != null) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = state.emailError!!),
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
                viewModel.updateEmailValue(it)
            })
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
            label = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.date_label),
            value = state.dateValue,
            interactionSource = source,
            readOnly = true,
            isError = state.isDateError,
            trailingIcon = {
                if (state.isDateError) {
                    Icon(
                        painter = painterResource(id = ru.madmax.composetwitterclone.feature.registry.R.drawable.ic_error),
                        contentDescription = ""
                    )
                } else if (state.dateValue.isNotEmpty()) {
                    Icon(
                        painter = painterResource(id = ru.madmax.composetwitterclone.feature.registry.R.drawable.ic_check),
                        contentDescription = ""
                    )
                }
            },
            supportingText = {
                if (state.isDateError && state.dateError != null) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = state.dateError!!),
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
            onValueChange = {})
        Spacer(
            modifier = Modifier
                .weight(0.5f)
                .imePadding()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(0.1f))
                TButton(enabled = state.isButtonEnabled,
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = {
                        navController.navigate(viewModel.createRoute())
                        keyboardController?.hide()
                    }) {
                    Text(stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.next_button_label))
                }
            }
        }

    }
}