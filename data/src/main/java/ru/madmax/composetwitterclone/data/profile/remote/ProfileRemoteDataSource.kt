package ru.madmax.composetwitterclone.data.profile.remote

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import ru.madmax.composetwitterclone.data.util.BasicApiResponse
import java.net.URL

interface ProfileRemoteDataSource {

    @Multipart
    @PUT("profile/image")
    suspend fun uploadProfileImage(
        @Part image: MultipartBody.Part
    ): BasicApiResponse<URL>


    @Multipart
    @PUT("profile/update")
    suspend fun updateProfile(
        @Part bannerImage: MultipartBody.Part?,
        @Part profilePicture: MultipartBody.Part?,
        @Part updateProfileData: MultipartBody.Part
    ): BasicApiResponse<Unit>
}