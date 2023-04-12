package ru.madmax.feature.registry.util

import android.text.TextUtils
import ru.madmax.feature.registry.R

class ValidateName {

    operator fun invoke(email: String): ValidationResult {
        return if (TextUtils.isEmpty(email)) {
            ValidationResult(
                successful = false,
                errorMessage = R.string.email_is_empty
            )
        } else {
            ValidationResult(
                successful = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches(),
                errorMessage = R.string.email_is_not_valid
            )
        }
    }
}