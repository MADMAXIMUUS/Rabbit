package ru.madmax.composetwitterclone.feature.registry.ui.setProfileBio

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import ru.madmax.composetwitterclone.core.ui.R
import ru.madmax.composetwitterclone.core.ui.components.TButton
import ru.madmax.composetwitterclone.core.ui.components.TMultiLineProfileTextField
import ru.madmax.composetwitterclone.core.ui.components.TOutlineButton
import ru.madmax.composetwitterclone.core.ui.components.TTopAppBar
import ru.madmax.composetwitterclone.util.UiAction
import ru.madmax.composetwitterclone.util.asString

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileBioRoute(
    snackbarHostState: SnackbarHostState,
    viewModel: SetProfileBioViewModel = hiltViewModel(),
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
                        message = event.message.asString(context), duration = SnackbarDuration.Short
                    )
                }

                is UiAction.Navigate -> {
                    navigateToNextScreen(event.route)
                    keyboardController?.hide()
                }

                else -> {}
            }
        }
    }

    SetProfileBioScreen(
        state = state,
        updateText = viewModel::updateText,
        skip = viewModel::skip,
        next = viewModel::next
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetProfileBioScreen(
    state: SetProfileBioScreenState,
    updateText: (text: String) -> Unit,
    skip: () -> Unit,
    next: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        TTopAppBar(title = {
            Icon(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.app_logo),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = ""
            )
        })
        Spacer(modifier = Modifier.weight(0.05f))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = "Describe yourself",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = "What makes you special? Don't think too hard, just have fun with it.",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(10.dp))
        TMultiLineProfileTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
            label = "Your bio",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
            ),
            value = state.text,
            supportingText = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "${state.textLength}/160",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            onValueChange = {
                updateText(it)
            })
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
                TOutlineButton(modifier = Modifier.padding(start = 10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.secondary
                    ),
                    border = BorderStroke(
                        width = 1.dp, color = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = {
                        skip()
                    }) {
                    Text(stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.skip_button_label))
                }
                Spacer(modifier = Modifier.weight(0.1f))
                TButton(
                    enabled = state.isButtonEnabled,
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = {
                        next()
                    },
                    contentPadding = if (state.isLoading) PaddingValues(
                        horizontal = 34.dp
                    ) else ButtonDefaults.ContentPadding
                ) {
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 3.dp,
                            strokeCap = StrokeCap.Round
                        )
                    } else {
                        Text(
                            text = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.next_button_label)
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
fun BioPreview() {
    SetProfileBioScreen(
        state = SetProfileBioScreenState(),
        updateText = {},
        skip = {},
        next = {}
    )
}