package ru.madmax.rabbit.feature.registry.util

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: Int? = null
)