package ru.madmax.composetwitterclone.feature.registry.ui.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.madmax.composetwitterclone.core.ui.components.TButton
import ru.madmax.composetwitterclone.core.ui.components.TOutlineButton
import ru.madmax.composetwitterclone.feature.registry.R

@Composable
internal fun WelcomeScreen(
    navigateToGoogleAuth: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToLogIn: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.3f)
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
                .weight(0.1f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(300.dp),
                painter = painterResource(id = ru.madmax.composetwitterclone.core.ui.R.drawable.app_logo),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = ""
            )
        }
        Spacer(
            modifier = Modifier
                .weight(0.1f)
        )
        TOutlineButton(
            onClick = {
                navigateToGoogleAuth()
            },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.secondary
            ),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            text = {
                Text(text = stringResource(R.string.sign_in_with_google), fontSize = 15.sp)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = ""
                )
            },
            contentPadding = PaddingValues(vertical = 15.dp, horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
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
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Divider(
                modifier = Modifier
                    .weight(0.5f)
                    .height(2.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        TButton(
            onClick = {
                navigateToSignUp()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            contentPadding = PaddingValues(vertical = 15.dp, horizontal = 24.dp)
        ) {
            Text(text = stringResource(R.string.create_account), fontSize = 15.sp)
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
                .weight(0.2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    WelcomeScreen(
        navigateToGoogleAuth = {},
        navigateToSignUp = {},
        navigateToLogIn = {}
    )
}