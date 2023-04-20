package ru.madmax.composetwitterclone.data.auth.remote

import retrofit2.http.Body
import retrofit2.http.POST
import ru.madmax.composetwitterclone.data.util.BasicApiResponse

interface AuthRemoteSource {

    @POST("auth/signUp")
    suspend fun signUp(
        @Body signUpModel: SignUpModel
    ): BasicApiResponse<AuthResponse>

    @POST("auth/login")
    suspend fun login(
        @Body loginModel: LoginModel
    ): BasicApiResponse<AuthResponse>

    @POST("auth/resetPassword")
    suspend fun forgetPassword(): BasicApiResponse<Boolean>

}