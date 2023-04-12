package ru.madmax.feature.registry.ui.signUpConfirm

import java.time.LocalDate

data class SignUpConfirmScreenState(
    val nameValue: String = "",
    val emailValue: String = "",
    val dateValue: String = "",
    val localDateValue: LocalDate = LocalDate.now(),
    val passwordValue: String = "",
    val passwordError: Int? = null,
    val isPasswordError: Boolean = false,
    val passwordShow: Boolean = false,
)