package ru.madmax.composetwitterclone.util

sealed class UiAction {
    data class ShowSnackbar(val message: UiText) : UiAction()
    data class Navigate(val route: String) : UiAction()
    object NavigateUp : UiAction()
}