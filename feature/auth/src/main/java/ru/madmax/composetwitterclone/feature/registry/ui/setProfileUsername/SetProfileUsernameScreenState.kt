package ru.madmax.composetwitterclone.feature.registry.ui.setProfileUsername

data class SetProfileUsernameScreenState(
    val isButtonEnabled: Boolean = false,
    val text: String = "",
    val isLoading: Boolean = false
)
