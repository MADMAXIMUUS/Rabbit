package ru.madmax.composetwitterclone.data.util

data class BasicApiResponse<T>(
    val isSuccessful: Boolean,
    val message: String? = null,
    val data: T? = null
)
