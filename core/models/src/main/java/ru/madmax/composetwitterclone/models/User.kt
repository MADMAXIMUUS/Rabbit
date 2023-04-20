package ru.madmax.composetwitterclone.models

data class User(
    val name: String = "",
    val email: String = "",
    val date: Long = 0,
    val nickname: String = "",
    val imageUri: String = ""
)