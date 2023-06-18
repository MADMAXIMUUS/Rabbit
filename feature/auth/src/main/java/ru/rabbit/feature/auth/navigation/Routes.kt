package ru.rabbit.feature.auth.navigation

import ru.rabbit.feature.auth.navigation.Routes.FORGOT_PASSWORD_SCREEN_ROUTE

internal object Routes {
    const val WELCOME_SCREEN_ROUTE = "welcome_route"
    const val SIGN_UP_SCREEN_ROUTE = "sign_up_route"
    const val SET_PROFILE_IMAGE_SCREEN_ROUTE = "set_profile_image_route"
    const val SET_PROFILE_BIO_SCREEN_ROUTE = "set_profile_bio_route"
    const val SET_USERNAME_SCREEN_ROUTE = "set_username_route"
    const val LOG_IN_SCREEN_ROUTE = "log_in_route"
    const val FORGOT_PASSWORD_SCREEN_ROUTE = "forgot_password_route"
    const val ENTER_CODE_SCREEN_ROUTE = "enter_code_route"
}

internal object RoutesPattern {
    const val FORGOT_PASSWORD_PATTERN = "$FORGOT_PASSWORD_SCREEN_ROUTE?email={email}"
}