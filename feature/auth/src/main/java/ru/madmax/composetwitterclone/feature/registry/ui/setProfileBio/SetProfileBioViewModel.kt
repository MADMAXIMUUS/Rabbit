package ru.madmax.composetwitterclone.feature.registry.ui.setProfileBio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.madmax.composetwitterclone.data.profile.ProfileRepository
import ru.madmax.composetwitterclone.data.util.Resource
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.SET_USERNAME_SCREEN_ROUTE
import ru.madmax.composetwitterclone.util.UiAction
import ru.madmax.composetwitterclone.util.UiText
import javax.inject.Inject


@HiltViewModel
class SetProfileBioViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SetProfileBioScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiAction>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun next() {
        viewModelScope.launch {
            when (val response = profileRepository.updateProfileInfo(bio = uiState.value.text)) {
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiAction.ShowSnackbar(
                            response.message ?: UiText.StringResource(
                                ru.madmax.composetwitterclone.data.R.string.unknown_error
                            )
                        )
                    )
                }

                is Resource.Success -> {
                    _eventFlow.emit(UiAction.Navigate(SET_USERNAME_SCREEN_ROUTE))
                }
            }
        }
    }

    fun skip() {
        viewModelScope.launch {
            _eventFlow.emit(UiAction.Navigate(SET_USERNAME_SCREEN_ROUTE))
        }
    }

    fun updateText(text: String) {
        if (text.length <= 160) {
            _uiState.update { currentState ->
                currentState.copy(
                    isButtonEnabled = text.isNotEmpty(),
                    text = text,
                    textLength = text.length
                )
            }
        }
    }

}