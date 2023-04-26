package ru.madmax.composetwitterclone.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.CoroutineScope

@ExperimentalAnimationApi
@Composable
fun rememberAppState(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberAnimatedNavController()
) = remember(snackbarHostState, drawerState, navController) {
    AppState(snackbarHostState, drawerState, coroutineScope, navController)
}

@Stable
class AppState(
    val snackbarHostState: SnackbarHostState,
    val drawerState: DrawerState,
    val coroutineScope: CoroutineScope,
    val navController: NavHostController
)


