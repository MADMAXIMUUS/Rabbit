package ru.madmax.rabbit.feature.registry.ui.forgotPassword

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
import ru.madmax.rabbit.feature.registry.navigation.Routes.ENTER_CODE_SCREEN_ROUTE
import ru.madmax.rabbit.feature.registry.util.ValidateEmail
import ru.madmax.rabbit.util.UiAction
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ForgotPasswordScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiAction>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun updateEmailValue(email: String) {
        val validResult = ValidateEmail().invoke(email)
        _uiState.update { currentState ->
            currentState.copy(
                emailValue = email,
                isEmailError = !validResult.successful,
                emailError = validResult.errorMessage,
                isButtonEnabled = validResult.successful
            )
        }
    }

    fun sendEmail() {
        viewModelScope.launch {
            authRepository.restorePassword(uiState.value.emailValue)
            _eventFlow.emit(UiAction.Navigate(ENTER_CODE_SCREEN_ROUTE))
        }
    }

}