package ru.rabbit.feature.auth.ui.forgotPassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import ru.rabbit.core.util.UiAction
import ru.rabbit.persian.components.TButton
import ru.rabbit.persian.components.TProfileTextFieldTrailing
import ru.rabbit.persian.components.TTopAppBarNavigationOnly
import ru.rabbit.persian.foundation.icons

@Composable
internal fun ForgotPasswordRoute(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    navigateUp: () -> Unit,
    navigateToNextScreen: (route: String) -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {

                is UiAction.Navigate -> {
                    navigateToNextScreen(event.route)
                }

                else -> {}
            }
        }
    }

    ForgotPasswordScreen(
        state = state,
        navigateUp = navigateUp,
        updateEmail = viewModel::updateEmailValue,
        sendEmail = viewModel::sendEmail,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ForgotPasswordScreen(
    state: ForgotPasswordScreenState,
    navigateUp: () -> Unit,
    updateEmail: (String) -> Unit,
    sendEmail: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        TTopAppBarNavigationOnly(
            navigationIcon = MaterialTheme.icons.arrowBack,
            navigationIconContentDescription = "",
            title = {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    painter = MaterialTheme.icons.appLogo,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = ""
                )
            },
            onNavigationClick = {
                navigateUp()
            }
        )
        Spacer(modifier = Modifier.weight(0.05f))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = "Find your Rabbit account",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = "Enter the email associated with your account to change your password",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(10.dp))
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
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))
                TButton(
                    enabled = state.isButtonEnabled,
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = {
                        sendEmail()
                    },
                    contentPadding = if (state.isLoading) PaddingValues(
                        horizontal = 34.dp
                    ) else
                        ButtonDefaults.ContentPadding
                ) {
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(20.dp),
                            strokeWidth = 3.dp,
                            strokeCap = StrokeCap.Round
                        )
                    } else {
                        Text(
                            text = stringResource(ru.rabbit.feature.auth.R.string.next_button_label)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    ForgotPasswordScreen(
        state = ForgotPasswordScreenState(),
        navigateUp = {},
        sendEmail = {},
        updateEmail = {}
    )
}