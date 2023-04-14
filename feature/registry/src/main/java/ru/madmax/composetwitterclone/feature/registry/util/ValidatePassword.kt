package ru.madmax.composetwitterclone.feature.registry.util

import ru.madmax.composetwitterclone.feature.registry.R

class ValidatePassword {

    operator fun invoke(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false, errorMessage = R.string.short_password
            )
        }
        val containsLettersAndDigits =
            password.any { it.isDigit() } && password.any { it.isLetter() }
        if (containsLettersAndDigits) {
            ValidationResult(
                successful = false, errorMessage = R.string.week_password
            )
        }
        return ValidationResult(successful = true)
    }
}