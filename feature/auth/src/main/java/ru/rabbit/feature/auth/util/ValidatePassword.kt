package ru.rabbit.feature.auth.util

import ru.rabbit.feature.auth.R

class ValidatePassword {

    operator fun invoke(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false, errorMessage = R.string.short_password
            )
        }
        return ValidationResult(successful = true)
    }
}