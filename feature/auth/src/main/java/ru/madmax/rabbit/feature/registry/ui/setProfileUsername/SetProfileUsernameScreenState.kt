package ru.madmax.rabbit.feature.registry.ui.setProfileUsername

data class SetProfileUsernameScreenState(
    val isButtonEnabled: Boolean = false,
    val text: String = "",
    val isLoading: Boolean = false
)
