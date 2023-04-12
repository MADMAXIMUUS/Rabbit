package ru.madmax.feature.registry.ui.signUpConfirm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.madmax.feature.registry.util.ValidatePassword
import toCalendarDate
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class SignUpConfirmViewModel @Inject constructor(
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpConfirmScreenState())
    val uiState = _uiState.asStateFlow()

    fun updateNameValue(name: String) {
        _uiState.update { currentState ->
            currentState.copy(
                nameValue = name,
            )
        }
    }

    fun updateEmailValue(email: String) {
        _uiState.update { currentState ->
            currentState.copy(
                emailValue = email,
            )
        }
    }

    fun updateDateState(date: String) {
        val localDate = Instant
            .ofEpochMilli(date.toLong())
            .atZone(ZoneId.systemDefault()).toLocalDate()
        _uiState.update { currentState ->
            currentState.copy(
                dateValue = localDate.atStartOfDay(
                    ZoneId.systemDefault()
                ).toInstant().toEpochMilli().toCalendarDate(),
                localDateValue = localDate,
            )
        }
    }

    fun updatePasswordState(password: String) {
        val validResult = ValidatePassword().invoke(password)
        _uiState.update { currentState ->
            currentState.copy(
                passwordValue = password,
                isPasswordError = !validResult.successful,
                passwordError = validResult.errorMessage
            )
        }
    }

    fun togglePassword() {
        _uiState.update { currentState ->
            currentState.copy(
                passwordShow = !currentState.passwordShow
            )
        }
    }
}