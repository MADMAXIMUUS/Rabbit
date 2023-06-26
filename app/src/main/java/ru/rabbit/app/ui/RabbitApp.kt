package ru.rabbit.app.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.navigation.animation.AnimatedNavHost
import ru.rabbit.feature.auth.navigation.AUTH_GRAPH_ROUTE_PATTERN
import ru.rabbit.feature.auth.navigation.authGraph
import ru.rabbit.feature.auth.navigation.navigateToAuthGraph
import ru.rabbit.persian.snackbar.PersianSnackbar
import ru.rabbit.persian.snackbar.PersianSnackbarVisuals

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun RabbitApp(
    shouldShowWelcomeScreen: Boolean
) {
    val appState = rememberAppState()
    Scaffold(bottomBar = {},
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = Color.Transparent,
        snackbarHost = {
            SnackbarHost(hostState = appState.snackbarHostState) { snackbarData ->
                val customVisuals = snackbarData.visuals as? PersianSnackbarVisuals
                if (customVisuals != null) {
                    PersianSnackbar.Primary(
                        text = customVisuals.message,
                        left = customVisuals.left,
                        right = customVisuals.right,
                        showOnTop = customVisuals.showOnTop,
                    )
                } else {
                    Snackbar(snackbarData = snackbarData)
                }
            }
        }) { padding ->
        AnimatedNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
            navController = appState.navController,
            startDestination = if (shouldShowWelcomeScreen) AUTH_GRAPH_ROUTE_PATTERN else ""
        ) {
            authGraph(
                navController = appState.navController,
                snackbarHostState = appState.snackbarHostState,
                onAuthenticate = {
                    appState.navController.navigateToAuthGraph()
                }
            )
        }
    }
}