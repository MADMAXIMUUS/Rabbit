package ru.madmax.rabbit.data.auth.remote

import retrofit2.http.Body
import retrofit2.http.POST
import ru.madmax.rabbit.data.util.BasicApiResponse

interface AuthRemoteDataSource {

    @POST("auth/signUp")
    suspend fun signUp(
        @Body signUpModel: SignUpModel
    ): BasicApiResponse<AuthResponse>

    @POST("auth/signIn")
    suspend fun login(
        @Body loginModel: LoginModel
    ): BasicApiResponse<AuthResponse>

    @POST("auth/resetPassword")
    suspend fun restorePassword(email: String): BasicApiResponse<Boolean>

    @POST("auth/code")
    suspend fun checkCode(code: String): BasicApiResponse<Boolean>

}