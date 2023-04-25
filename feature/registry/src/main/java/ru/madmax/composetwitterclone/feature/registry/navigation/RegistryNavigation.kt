package ru.madmax.composetwitterclone.feature.registry.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.MAIN_SIGN_UP_SCREEN
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.SET_PROFILE_BIO_SCREEN
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.SET_PROFILE_IMAGE_SCREEN
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.WELCOME_SCREEN
import ru.madmax.composetwitterclone.feature.registry.navigation.RoutesPattern.CONFIRM_SIGN_UP_SCREEN_PATTERN
import ru.madmax.composetwitterclone.feature.registry.ui.setProfileBio.SetProfileBioScreen
import ru.madmax.composetwitterclone.feature.registry.ui.setProfilePicture.SetProfileImageScreen
import ru.madmax.composetwitterclone.feature.registry.ui.signUpConfirm.SignUpConfirmScreen
import ru.madmax.composetwitterclone.feature.registry.ui.signUpMain.SignUpMainScreen
import ru.madmax.composetwitterclone.feature.registry.ui.welcome.WelcomeScreen

const val registryGraphRoutePattern = "registry_graph"

fun NavController.navigateToRegistryGraph(navOptions: NavOptions? = null) {
    this.navigate(WELCOME_SCREEN, navOptions)
}


@ExperimentalAnimationApi
fun NavGraphBuilder.registryGraph(
    navController: NavController,
    snackbarHostState: SnackbarHostState
) {
    navigation(
        route = registryGraphRoutePattern,
        startDestination = SET_PROFILE_BIO_SCREEN,
    ) {
        composable(
            route = WELCOME_SCREEN,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            }
        ) {
            WelcomeScreen(navController)
        }
        composable(
            route = MAIN_SIGN_UP_SCREEN,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            }
        ) {
            SignUpMainScreen(navController, snackbarHostState)
        }
        composable(
            route = CONFIRM_SIGN_UP_SCREEN_PATTERN,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            }
        ) {
            val name = it.arguments?.getString("name").toString()
            val email = it.arguments?.getString("email").toString()
            val date = it.arguments?.getString("date").toString()
            SignUpConfirmScreen(
                name = name,
                email = email,
                date = date,
                navController = navController,
                snackbarHostState
            )
        }
        composable(
            route = SET_PROFILE_IMAGE_SCREEN,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            }
        ) {
            SetProfileImageScreen(navController, snackbarHostState)
        }
        composable(
            route = SET_PROFILE_BIO_SCREEN,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) +fadeIn(animationSpec = tween(300))
            }
        ) {
            SetProfileBioScreen()
        }
    }
}