package ru.madmax.composetwitterclone.data.profile.remote

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import ru.madmax.composetwitterclone.data.util.BasicApiResponse
import java.net.URL

interface ProfileRemoteDataSource {

    @Multipart
    @POST("profile/image")
    suspend fun uploadProfileImage(
        @Part image: MultipartBody.Part
    ): BasicApiResponse<URL>

}