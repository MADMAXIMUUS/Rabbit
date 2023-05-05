package ru.madmax.rabbit.feature.registry.util

import android.text.TextUtils
import android.util.Patterns
import ru.madmax.rabbit.feature.registry.R

class ValidateEmail {

    operator fun invoke(email: String): ValidationResult {
        return if (TextUtils.isEmpty(email)) {
            ValidationResult(
                successful = false,
                errorMessage = R.string.email_is_empty
            )
        } else {
            ValidationResult(
                successful = Patterns.EMAIL_ADDRESS.matcher(email).matches(),
                errorMessage = R.string.email_is_not_valid
            )
        }
    }
}