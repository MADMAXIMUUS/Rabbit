package ru.rabbit.feature.auth.util

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: Int? = null
)