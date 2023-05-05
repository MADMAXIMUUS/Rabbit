package ru.madmax.rabbit.data.auth.remote

data class SignUpModel(
    val name: String = "",
    val email: String = "",
    val date: Long = 0L,
    val password: String
)
