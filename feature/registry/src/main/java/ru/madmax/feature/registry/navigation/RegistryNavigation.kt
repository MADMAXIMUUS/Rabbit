package ru.madmax.feature.registry.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.madmax.feature.registry.ui.signUp.SignUpScreenMain
import ru.madmax.feature.registry.ui.welcome.WelcomeScreen

const val registryGraphRoutePattern = "registry_graph"
private const val registryNavigationRoute = "registry_route"
private const val mainSignUpNavigationRoute = "main_sign_up_route"

fun NavController.navigateToRegistryGraph(navOptions: NavOptions? = null) {
    this.navigate(registryNavigationRoute, navOptions)
}

internal fun NavController.navigateToMainSignUp(navOptions: NavOptions? = null) {
    this.navigate(mainSignUpNavigationRoute, navOptions)
}

fun NavGraphBuilder.registryGraph(
    navController: NavController
) {
    navigation(
        route = registryGraphRoutePattern,
        startDestination = registryNavigationRoute,
    ) {
        composable(route = registryNavigationRoute) {
            WelcomeScreen(navController)
        }
        composable(route = mainSignUpNavigationRoute) {
            SignUpScreenMain()
        }
    }
}