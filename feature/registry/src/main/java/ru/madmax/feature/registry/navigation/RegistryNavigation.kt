package ru.madmax.feature.registry.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.madmax.feature.registry.navigation.RoutesPattern.CONFIRM_SIGN_UP_SCREEN_PATTERN
import ru.madmax.feature.registry.ui.signUpMain.SignUpMainScreen
import ru.madmax.feature.registry.ui.welcome.WelcomeScreen

const val registryGraphRoutePattern = "registry_graph"

fun NavController.navigateToRegistryGraph(navOptions: NavOptions? = null) {
    this.navigate(Routes.WELCOME_SCREEN, navOptions)
}

fun NavGraphBuilder.registryGraph(
    navController: NavController
) {
    navigation(
        route = registryGraphRoutePattern,
        startDestination = Routes.WELCOME_SCREEN,
    ) {
        composable(route = Routes.WELCOME_SCREEN) {
            WelcomeScreen(navController)
        }
        composable(route = Routes.MAIN_SIGN_UP_SCREEN) {
            SignUpMainScreen(navController)
        }
        composable(route = CONFIRM_SIGN_UP_SCREEN_PATTERN) {
            val name = it.arguments?.getString("name")
            val email = it.arguments?.getString("email")
            val date = it.arguments?.getString("date")

        }
    }
}