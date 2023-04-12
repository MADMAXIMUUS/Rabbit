package ru.madmax.feature.registry.ui.signUpMain

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.madmax.feature.registry.R
import ru.madmax.feature.registry.navigation.Routes
import ru.madmax.feature.registry.util.ValidateEmail
import toCalendarDate
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class SignUpMainViewModel @Inject constructor(
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpMainScreenState())
    val uiState = _uiState.asStateFlow()

    fun updateNameValue(name: String) {
        if (name.length <= 50) {
            _uiState.update { currentState ->
                currentState.copy(
                    nameValue = name,
                    isNameError = name.isEmpty(),
                    nameError = R.string.name_empty
                )
            }
            updateButtonState()
        }
    }

    fun updateEmailValue(email: String) {
        val validResult = ValidateEmail().invoke(email)
        _uiState.update { currentState ->
            currentState.copy(
                emailValue = email,
                isEmailError = !validResult.successful,
                emailError = validResult.errorMessage
            )
        }
        updateButtonState()
    }

    fun updateDateState(date: LocalDate) {
        _uiState.update { currentState ->
            currentState.copy(
                dateValue = date
                    .atStartOfDay(
                        ZoneId.systemDefault()
                    )
                    .toInstant()
                    .toEpochMilli()
                    .toCalendarDate(),
                localDateValue = date,
                isDateError = date > LocalDate.now().minusYears(13),
                dateError = R.string.date_not_valid
            )
        }
        updateButtonState()
    }

    private fun updateButtonState() {
        _uiState.update { currentState ->
            currentState.copy(
                isButtonEnabled = !currentState.isNameError &&
                        !currentState.isEmailError &&
                        !currentState.isDateError &&
                        currentState.nameValue.isNotEmpty() &&
                        currentState.dateValue.isNotEmpty()
            )
        }
    }

    fun createRoute(): String {
        return "${Routes.CONFIRM_SIGN_UP_SCREEN}/${_uiState.value.nameValue}/${_uiState.value.emailValue}/${
            _uiState.value.localDateValue.atStartOfDay(
                ZoneId.systemDefault()
            )
                .toInstant()
                .toEpochMilli()
        }"
    }

}