package ru.rabbit.feature.auth.ui.setProfileBio

data class SetProfileBioScreenState(
    val isButtonEnabled: Boolean = false,
    val text: String = "",
    val textLength: Int = 0,
    val isLoading: Boolean = false
)
