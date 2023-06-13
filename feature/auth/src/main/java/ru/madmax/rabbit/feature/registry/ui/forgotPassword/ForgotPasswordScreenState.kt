package ru.madmax.rabbit.feature.registry.ui.forgotPassword

data class ForgotPasswordScreenState(
    val emailValue: String = "",
    val emailError: Int? = null,
    val isEmailError: Boolean = false,
    val isButtonEnabled: Boolean =false,
    val isLoading: Boolean = false
)
