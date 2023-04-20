package ru.madmax.composetwitterclone.feature.registry.ui.signUpConfirm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.madmax.composetwitterclone.data.auth.AuthRepository
import ru.madmax.composetwitterclone.data.util.Resource
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.SET_PROFILE_IMAGE_SCREEN
import ru.madmax.composetwitterclone.feature.registry.util.ValidatePassword
import ru.madmax.composetwitterclone.util.UiAction
import ru.madmax.composetwitterclone.util.UiText
import toCalendarDate
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class SignUpConfirmViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpConfirmScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiAction>()
    val eventFlow = _eventFlow.asSharedFlow()

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

    fun signUp() {
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
        viewModelScope.launch {
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
                    _eventFlow.emit(UiAction.Navigate(SET_PROFILE_IMAGE_SCREEN))
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
                                ru.madmax.composetwitterclone.data.R.string.unknown_error
                            )
                        )
                    )
                }
            }
        }
    }
}