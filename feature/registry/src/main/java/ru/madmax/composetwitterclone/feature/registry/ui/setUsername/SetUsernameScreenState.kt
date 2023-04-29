package ru.madmax.composetwitterclone.feature.registry.ui.setUsername

data class SetUsernameScreenState(
    val isButtonEnabled: Boolean = false,
    val text: String = "",
    val isLoading: Boolean = false
)
