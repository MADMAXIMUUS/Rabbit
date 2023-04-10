package ru.madmax.feature.registry.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.madmax.core.ui.components.TButton
import ru.madmax.core.ui.components.TOutlineButton
import ru.madmax.core.ui.components.TTopAppBar
import ru.madmax.core.ui.theme.ComposeTwitterCloneTheme
import ru.madmax.feature.registry.R
import ru.madmax.feature.registry.navigation.navigateToMainSignUp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TTopAppBar(
            title = {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    painter = painterResource(id = ru.madmax.core.ui.R.drawable.app_logo),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = ""
                )
            },
        )
        Spacer(
            modifier = Modifier
                .weight(0.5f)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 40.dp),
            text = stringResource(R.string.welcome_message),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .weight(0.5f)
        )
        TOutlineButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            text = {
                Text(text = stringResource(R.string.sign_in_with_google))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = ""
                )
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .weight(0.5f)
                    .height(2.dp)
            )
            Text(
                text = stringResource(R.string.or),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Divider(
                modifier = Modifier
                    .weight(0.5f)
                    .height(2.dp)
            )
        }
        TButton(
            onClick = {
                navController.navigateToMainSignUp()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(text = stringResource(R.string.create_account))
        }
        Spacer(
            modifier = Modifier
                .weight(0.1f)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 30.dp),
            text = stringResource(R.string.privacy_message),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(
            modifier = Modifier
                .weight(0.1f)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 30.dp),
            text = stringResource(R.string.have_account_hint),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(
            modifier = Modifier
                .weight(0.1f)
        )
    }
}