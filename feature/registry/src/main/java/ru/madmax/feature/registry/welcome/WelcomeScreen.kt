package ru.madmax.feature.registry

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.madmax.core.ui.components.TButton
import ru.madmax.core.ui.components.TOutlineButton

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                WindowInsets.systemBars
                    .only(WindowInsetsSides.Top)
                    .asPaddingValues()
            )
    ) {
        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            imageVector = ImageVector
                .vectorResource(id = ru.madmax.core.ui.R.drawable.app_logo_splash),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = ""
        )
        Spacer(
            modifier = Modifier
                .weight(0.5f)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 40.dp),
            text = "See what's happening in the world right now.",
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
                Text(text = "Sign in with Google")
            },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector
                        .vectorResource(id = R.drawable.ic_google),
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
            Text(text = "or", modifier = Modifier.padding(horizontal = 10.dp))
            Divider(
                modifier = Modifier
                    .weight(0.5f)
                    .height(2.dp)
            )
        }
        TButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(text = "Create account")
        }
        Spacer(
            modifier = Modifier
                .weight(0.1f)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 30.dp),
            text = "By signing up, you agree to our Terms, Privacy Policy and Cookie Use",
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