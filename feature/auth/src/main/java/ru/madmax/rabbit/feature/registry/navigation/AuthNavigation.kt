package ru.madmax.rabbit.feature.registry.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import ru.madmax.rabbit.feature.registry.navigation.Routes.ENTER_CODE_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.navigation.Routes.LOG_IN_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.navigation.Routes.SET_PROFILE_BIO_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.navigation.Routes.SET_PROFILE_IMAGE_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.navigation.Routes.SET_USERNAME_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.navigation.Routes.SIGN_UP_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.navigation.Routes.WELCOME_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.navigation.RoutesPattern.FORGOT_PASSWORD_PATTERN
import ru.madmax.rabbit.feature.registry.ui.forgotPassword.ForgotPasswordRoute
import ru.madmax.rabbit.feature.registry.ui.forgotPassword.ForgotPasswordViewModel
import ru.madmax.rabbit.feature.registry.ui.logIn.LogInRoute
import ru.madmax.rabbit.feature.registry.ui.setProfileBio.ProfileBioRoute
import ru.madmax.rabbit.feature.registry.ui.setProfilePicture.ProfileImageRoute
import ru.madmax.rabbit.feature.registry.ui.setProfileUsername.ProfileUsernameRoute
import ru.madmax.rabbit.feature.registry.ui.signUp.SignUpRoute
import ru.madmax.rabbit.feature.registry.ui.welcome.WelcomeScreen

const val AUTH_GRAPH_ROUTE_PATTERN = "registry_graph"

fun NavController.navigateToAuthGraph(navOptions: NavOptions? = null) {
    this.navigate(AUTH_GRAPH_ROUTE_PATTERN, navOptions)
}

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
fun NavGraphBuilder.authGraph(
    navController: NavController,
    snackbarHostState: SnackbarHostState,
    onAuthenticate: () -> Unit
) {
    navigation(
        route = AUTH_GRAPH_ROUTE_PATTERN,
        startDestination = WELCOME_SCREEN_ROUTE,
    ) {
        composable(
            route = WELCOME_SCREEN_ROUTE,
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
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
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
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            WelcomeScreen(
                navigateToGoogleAuth = {},
                navigateToSignUp = { navController.navigate(SIGN_UP_SCREEN_ROUTE) },
                navigateToLogIn = { navController.navigate(LOG_IN_SCREEN_ROUTE) }
            )
        }
        composable(
            route = SIGN_UP_SCREEN_ROUTE,
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
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
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
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            SignUpRoute(
                snackbarHostState = snackbarHostState,
                navigateUp = navController::navigateUp,
                navigateToNextScreen = {
                    navController.navigate(it) {
                        popUpTo(SIGN_UP_SCREEN_ROUTE) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = SET_PROFILE_IMAGE_SCREEN_ROUTE,
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
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
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
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            ProfileImageRoute(
                snackbarHostState = snackbarHostState,
                navigateToNextScreen = {
                    navController.navigate(it) {
                        popUpTo(SET_PROFILE_IMAGE_SCREEN_ROUTE) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = SET_PROFILE_BIO_SCREEN_ROUTE,
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
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
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
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            ProfileBioRoute(
                snackbarHostState = snackbarHostState,
                navigateToNextScreen = {
                    navController.navigate(it) {
                        popUpTo(SET_PROFILE_BIO_SCREEN_ROUTE) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = SET_USERNAME_SCREEN_ROUTE,
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
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
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
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            ProfileUsernameRoute(
                snackbarHostState = snackbarHostState,
                onAuthenticate = onAuthenticate
            )
        }
    }
}