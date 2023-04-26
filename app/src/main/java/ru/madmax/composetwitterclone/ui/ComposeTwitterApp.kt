package ru.madmax.composetwitterclone.ui

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
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.navigation.animation.AnimatedNavHost
import ru.madmax.composetwitterclone.feature.registry.navigation.registryGraph
import ru.madmax.composetwitterclone.feature.registry.navigation.registryGraphRoutePattern

@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalLayoutApi
@Composable
fun ComposeTwitterApp(
    shouldShowWelcomeScreen: Boolean
) {
    val appState = rememberAppState()
    Scaffold(
        bottomBar = {
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = Color.Transparent,
        snackbarHost = { SnackbarHost(hostState = appState.snackbarHostState) }
    ) { padding ->
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
            startDestination = if (shouldShowWelcomeScreen) registryGraphRoutePattern else ""
        ) {
            registryGraph(
                navController = appState.navController,
                snackbarHostState = appState.snackbarHostState
            )
        }
    }
}