package ru.madmax.feature.registry.ui.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.madmax.core.ui.R
import ru.madmax.core.ui.components.TButton
import ru.madmax.core.ui.components.TProfileTextField
import ru.madmax.core.ui.components.TTopAppBarNavigationOnly
import ru.madmax.core.ui.theme.ComposeTwitterCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenMain() {
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
            onNavigationClick = {})
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = "Create your account",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        TProfileTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
            label = "Name",
            value = "",
            onValueChange = {})
        TProfileTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
            label = "Phone number or email address",
            value = "",
            onValueChange = {})
        TProfileTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
            label = "Date of birth",
            value = "",
            onValueChange = {})
        Spacer(modifier = Modifier.weight(0.3f))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = "By signing up, you agree to Terms of Service and Privacy Policy, " +
                    "including Cookie Use. Twitter may use your contact information, " +
                    "including your email address and phone number for purposes outlined " +
                    "secure and personalizing our services, including ads. Learn more." +
                    "Others will be able to find you by email or phone number, when provided, " +
                    "unless you choose otherwise here.",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(10.dp))
        TButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            contentPadding = PaddingValues(vertical = 15.dp)
        ) {
            Text(text = "Sign up")
        }
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun PreviewSignUp() {
    ComposeTwitterCloneTheme(dynamicColor = false) {
        SignUpScreenMain()
    }
}