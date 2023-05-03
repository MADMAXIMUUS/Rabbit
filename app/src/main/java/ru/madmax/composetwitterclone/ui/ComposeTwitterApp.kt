package ru.madmax.composetwitterclone.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.navigation.animation.AnimatedNavHost
import ru.madmax.composetwitterclone.feature.registry.navigation.authGraph
import ru.madmax.composetwitterclone.feature.registry.navigation.AUTH_GRAPH_ROUTE_PATTERN
import ru.madmax.composetwitterclone.feature.registry.navigation.navigateToAuthGraph

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun ComposeTwitterApp(
    shouldShowWelcomeScreen: Boolean
) {
    val appState = rememberAppState()
    Scaffold(bottomBar = {},
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = Color.Transparent,
        snackbarHost = {
            SnackbarHost(hostState = appState.snackbarHostState) { snackbarData ->
                /*val customVisuals = snackbarData.visuals as? SnackbarVisualsCustom
                if (customVisuals != null) {
                    TSnackbar(
                        icon = customVisuals.icon,
                        message = customVisuals.message,
                        colors = customVisuals.colors,
                        closeIcon = customVisuals.closeIcon,
                        actionLabel = customVisuals.actionLabel,
                        isOnTop = customVisuals.isOnTop
                    )
                } else {
                    Snackbar(snackbarData = snackbarData)
                }*/
                Snackbar(
                    snackbarData = snackbarData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 50.dp),
                    shape = MaterialTheme.shapes.large,
                )
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