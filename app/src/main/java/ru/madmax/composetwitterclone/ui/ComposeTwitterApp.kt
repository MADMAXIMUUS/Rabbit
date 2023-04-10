package ru.madmax.composetwitterclone.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import ru.madmax.feature.registry.navigation.registryGraph
import ru.madmax.feature.registry.navigation.registryGraphRoutePattern

@Composable
fun ComposeTwitterApp(
    shouldShowWelcomeScreen: Boolean
) {
    val appState = rememberAppState()
    Scaffold(
        bottomBar = {

        },
        snackbarHost = { SnackbarHost(hostState = appState.snackbarHostState) }
    ) {
        NavHost(
            navController = appState.navController,
            startDestination = if (shouldShowWelcomeScreen) registryGraphRoutePattern else ""
        ) {
            registryGraph(navController = appState.navController)
        }
    }
}