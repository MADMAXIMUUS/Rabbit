package ru.madmax.composetwitterclone.data.auth.remote

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("user_id")
    val userId: String = "",
    val token: String = ""
)
