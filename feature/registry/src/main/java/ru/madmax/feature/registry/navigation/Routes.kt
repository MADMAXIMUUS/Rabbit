package ru.madmax.feature.registry.navigation

internal object Routes {
    const val WELCOME_SCREEN = "welcome_route"
    const val MAIN_SIGN_UP_SCREEN = "main_sign_up_route"
    const val CONFIRM_SIGN_UP_SCREEN = "confirm_sign_up_route"
}

internal object RoutesPattern{
    const val CONFIRM_SIGN_UP_SCREEN_PATTERN = "confirm_sign_up_route/{name}/{email}/{date}"
}