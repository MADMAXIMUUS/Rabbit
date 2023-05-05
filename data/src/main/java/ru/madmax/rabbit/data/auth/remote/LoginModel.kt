package ru.madmax.rabbit.data.auth.remote

data class LoginModel(
    val email: String = "",
    val password: String = ""
)