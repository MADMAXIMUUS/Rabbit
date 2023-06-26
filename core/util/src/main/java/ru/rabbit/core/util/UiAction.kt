package ru.rabbit.core.util

sealed class UiAction {
    data class ShowSnackbar(
        val message: UiText,
        val imageUrl: String = ""
    ) : UiAction()

    data class Navigate(val route: String) : UiAction()
    object NavigateUp : UiAction()
}