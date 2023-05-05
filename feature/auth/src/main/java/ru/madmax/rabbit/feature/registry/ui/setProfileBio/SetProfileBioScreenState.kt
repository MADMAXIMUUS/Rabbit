package ru.madmax.rabbit.feature.registry.ui.setProfileBio

data class SetProfileBioScreenState(
    val isButtonEnabled: Boolean = false,
    val text: String = "",
    val textLength: Int = 0,
    val isLoading: Boolean = false
)
