package ru.madmax.rabbit.feature.registry.ui.logIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.madmax.rabbit.data.auth.AuthRepository
import ru.madmax.rabbit.data.util.Resource
import ru.madmax.rabbit.feature.registry.R
import ru.madmax.rabbit.feature.registry.navigation.Routes.FORGOT_PASSWORD_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.util.ValidateEmail
import ru.madmax.rabbit.feature.registry.util.ValidatePassword
import ru.madmax.rabbit.util.UiAction
import ru.madmax.rabbit.util.UiText
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LogInScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiAction>()
    val eventFlow = _eventFlow.asSharedFlow()

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

    fun forgotPassword() {
        viewModelScope.launch {
            if (uiState.value.emailValue.isNotEmpty()) {
                _eventFlow.emit(
                    UiAction
                        .Navigate("$FORGOT_PASSWORD_SCREEN_ROUTE?email=${uiState.value.emailValue}")
                )
            } else {
                _eventFlow.emit(
                    UiAction
                        .Navigate(FORGOT_PASSWORD_SCREEN_ROUTE)
                )
            }
        }
    }

    fun logIn() {
        _uiState.update { currentState ->
            currentState.copy(
                isEmailError = uiState.value.emailValue.isEmpty(),
                emailError = R.string.email_is_empty,
                isPasswordError = uiState.value.passwordValue.isEmpty(),
                passwordError = R.string.password_empty
            )
        }
        if (!uiState.value.isEmailError && !uiState.value.isPasswordError) {
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = true
                )
            }
            viewModelScope.launch {
                val response = repository.signIn(
                    uiState.value.emailValue,
                    uiState.value.passwordValue
                )
                when (response) {
                    is Resource.Success -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoading = false
                            )
                        }
                        _eventFlow.emit(UiAction.Navigate(""))
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
                                    ru.madmax.rabbit.data.R.string.unknown_error
                                )
                            )
                        )
                    }
                }
            }
        }
    }

}