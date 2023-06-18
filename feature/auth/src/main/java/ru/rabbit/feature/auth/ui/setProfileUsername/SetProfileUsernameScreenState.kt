package ru.rabbit.feature.auth.ui.setProfileUsername

data class SetProfileUsernameScreenState(
    val isButtonEnabled: Boolean = false,
    val text: String = "",
    val isLoading: Boolean = false
)
