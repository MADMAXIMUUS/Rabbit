package ru.madmax.rabbit.data.auth

import ru.madmax.rabbit.data.util.Resource

interface AuthRepository {

    suspend fun signUp(name: String, email: String, date: Long, password: String): Resource<Unit>

    suspend fun signInWithGoogle(): Resource<Unit>

    suspend fun signIn(email: String, password: String): Resource<Unit>

    suspend fun restorePassword(email: String): Resource<Unit>

    suspend fun checkCode(code: String): Resource<Unit>
}