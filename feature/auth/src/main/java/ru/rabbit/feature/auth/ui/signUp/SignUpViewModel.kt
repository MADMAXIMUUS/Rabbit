package ru.rabbit.feature.auth.ui.signUp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.rabbit.data.auth.AuthRepository
import ru.rabbit.feature.auth.R
import ru.rabbit.feature.auth.util.ValidateEmail
import ru.rabbit.feature.auth.util.ValidatePassword
import ru.rabbit.core.util.UiAction
import ru.rabbit.feature.auth.util.toCalendarDate
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiAction>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun updateNameValue(name: String) {
        if (name.length <= 50) {
            _uiState.update { currentState ->
                currentState.copy(
                    nameValue = name,
                    isNameError = name.isEmpty(),
                    nameError = R.string.name_empty
                )
            }
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

    fun signUp() {
        _uiState.update { currentState ->
            currentState.copy(
                isNameError = uiState.value.nameValue.isEmpty(),
                nameError = R.string.name_empty,
                isEmailError = uiState.value.emailValue.isEmpty(),
                emailError = R.string.email_is_empty,
                isDateError = uiState.value.dateValue.isEmpty(),
                dateError = R.string.date_not_valid,
                isPasswordError = uiState.value.passwordValue.isEmpty(),
                passwordError = R.string.password_empty
            )
        }
        if (!uiState.value.isNameError && !uiState.value.isEmailError && !uiState.value.isDateError && !uiState.value.isPasswordError) {
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = true
                )
            }
            val date = uiState
                .value
                .localDateValue
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()
            /*viewModelScope.launch {
                val response = repository.signUp(
                    uiState.value.nameValue,
                    uiState.value.emailValue,
                    date,
                    uiState.value.passwordValue
                )
                when (response) {
                    is Resource.Success -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoading = false
                            )
                        }
                        _eventFlow.emit(UiAction.Navigate(Routes.SET_PROFILE_IMAGE_SCREEN_ROUTE))
                    }

                    is Resource.Error -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoading = false
                            )
                        }
                        _eventFlow.emit(
                            UiAction.ShowSnackbar(
                                response.message ?: UiText.StringResource(
                                    ru.rabbit.data.R.string.unknown_error
                                )
                            )
                        )
                    }
                }
            }*/
        }
    }
}