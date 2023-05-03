package ru.madmax.composetwitterclone.feature.registry.ui.signUp

import com.maxkeppeker.sheets.core.models.base.UseCaseState
import java.time.LocalDate

data class SignUpScreenState(
    val nameValue: String = "",
    val nameError: Int? = null,
    val isNameError: Boolean = false,
    val isShowDatePicker: Boolean = true,
    val emailValue: String = "",
    val emailError: Int? = null,
    val isEmailError: Boolean = false,
    val dateValue: String = "",
    val localDateValue: LocalDate = LocalDate.now(),
    val dateError: Int? = null,
    val isDateError: Boolean = false,
    val calendarState: UseCaseState = UseCaseState(visible = false),
    val passwordValue: String = "",
    val passwordError: Int? = null,
    val isPasswordError: Boolean = false,
    val passwordShow: Boolean = false,
    val isLoading: Boolean = false
)