package ru.madmax.rabbit.feature.registry.ui.enterCode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.madmax.rabbit.data.auth.AuthRepository
import ru.madmax.rabbit.feature.registry.navigation.Routes.WELCOME_SCREEN_ROUTE
import ru.madmax.rabbit.util.UiAction
import javax.inject.Inject

@HiltViewModel
class EnterCodeViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(EnterCodeScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiAction>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun checkCode() {
        viewModelScope.launch {
            _eventFlow.emit(UiAction.Navigate(WELCOME_SCREEN_ROUTE))
        }
    }

}