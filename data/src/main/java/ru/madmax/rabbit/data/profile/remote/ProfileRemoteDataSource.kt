package ru.madmax.rabbit.data.profile.remote

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import ru.madmax.rabbit.data.util.BasicApiResponse
import java.net.URL

interface ProfileRemoteDataSource {

    @Multipart
    @PUT("profile/image")
    suspend fun uploadProfileImage(
        @Part image: MultipartBody.Part
    ): BasicApiResponse<URL>


    @Multipart
    @PUT("profile/data")
    suspend fun updateProfile(
        @Part bannerImage: MultipartBody.Part?,
        @Part profilePicture: MultipartBody.Part?,
        @Part updateProfileData: MultipartBody.Part
    ): BasicApiResponse<Unit>
}