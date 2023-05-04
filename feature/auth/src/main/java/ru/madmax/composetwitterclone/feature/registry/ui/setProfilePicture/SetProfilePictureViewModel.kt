package ru.madmax.composetwitterclone.feature.registry.ui.setProfilePicture

import android.graphics.Bitmap
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
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.SET_PROFILE_BIO_SCREEN_ROUTE
import ru.madmax.composetwitterclone.util.UiAction
import ru.madmax.composetwitterclone.util.UiText
import java.io.File
import javax.inject.Inject


@HiltViewModel
class SetProfilePictureViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SetProfilePictureScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiAction>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun next(file: File) {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = true
                )
            }
            when (val response = profileRepository.setProfilePhoto(file)) {
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
                    _uiState.update { currentState ->
                        currentState.copy(
                            isLoading = false
                        )
                    }
                    _eventFlow.emit(UiAction.Navigate(SET_PROFILE_BIO_SCREEN_ROUTE))
                }
            }
        }
    }

    fun skip() {
        viewModelScope.launch {
            _eventFlow.emit(UiAction.Navigate(SET_PROFILE_BIO_SCREEN_ROUTE))
        }
    }

    fun setPhoto(bitmap: Bitmap) {
        _uiState.update { currentState ->
            currentState.copy(
                isNeedCropDialog = true,
                photo = bitmap,
                photoWidth = bitmap.width,
                photoHeight = bitmap.height
            )
        }
    }

    fun showDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                isNeedTypeDialog = true
            )
        }
    }

    fun hideDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                isNeedTypeDialog = false
            )
        }
    }

    fun setCroppedPhoto(photo: Bitmap?) {
        if (photo != null) {
            _uiState.update { currentState ->
                currentState.copy(
                    croppedPhoto = photo,
                    isButtonEnabled = true
                )
            }
        }
        _uiState.update { currentState ->
            currentState.copy(
                isNeedCropDialog = false
            )
        }
    }

}