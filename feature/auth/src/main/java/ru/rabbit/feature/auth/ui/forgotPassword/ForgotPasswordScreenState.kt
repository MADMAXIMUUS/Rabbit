package ru.rabbit.feature.auth.ui.forgotPassword

data class ForgotPasswordScreenState(
    val emailValue: String = "",
    val emailError: Int? = null,
    val isEmailError: Boolean = false,
    val isButtonEnabled: Boolean =false,
    val isLoading: Boolean = false
)
