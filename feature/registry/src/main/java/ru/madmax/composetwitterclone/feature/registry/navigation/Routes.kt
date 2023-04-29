package ru.madmax.composetwitterclone.feature.registry.navigation

internal object Routes {
    const val WELCOME_SCREEN = "welcome_route"
    const val MAIN_SIGN_UP_SCREEN = "main_sign_up_route"
    const val CONFIRM_SIGN_UP_SCREEN = "confirm_sign_up_route"
    const val SET_PROFILE_IMAGE_SCREEN = "set_profile_image_route"
    const val SET_PROFILE_BIO_SCREEN="set_profile_bio_route"
    const val SET_USERNAME_SCREEN="set_username_route"
}

internal object RoutesPattern{
    const val CONFIRM_SIGN_UP_SCREEN_PATTERN = "confirm_sign_up_route/{name}/{email}/{date}"
}