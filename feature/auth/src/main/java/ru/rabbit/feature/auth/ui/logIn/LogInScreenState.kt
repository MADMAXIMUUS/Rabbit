package ru.rabbit.feature.auth.ui.logIn

data class LogInScreenState(
    val emailValue: String = "",
    val emailError: Int? = null,
    val isEmailError: Boolean = false,
    val passwordValue: String = "",
    val passwordError: Int? = null,
    val isPasswordError: Boolean = false,
    val passwordShow: Boolean = false,
    val isLoading: Boolean = false
)
