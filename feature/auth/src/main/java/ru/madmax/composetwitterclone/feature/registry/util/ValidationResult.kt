package ru.madmax.composetwitterclone.feature.registry.util

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: Int? = null
)