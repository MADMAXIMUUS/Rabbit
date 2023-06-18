package ru.rabbit.data.profile

import com.google.gson.Gson
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import ru.rabbit.data.profile.remote.ProfileRemoteDataSource
import ru.rabbit.data.profile.remote.UpdateProfileData
import ru.rabbit.data.util.Resource
import ru.rabbit.core.util.UiText
import ru.rabbit.data.R
import java.io.File
import java.io.IOException
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileRemoteDataSource: ProfileRemoteDataSource,
    private val gson: Gson,
) : ProfileRepository {

    override suspend fun setProfilePhoto(image: File): Resource<Unit> {
        return try {
            val response = profileRemoteDataSource.uploadProfileImage(
                image = MultipartBody.Part.createFormData(
                    name = "image",
                    filename = image.name,
                    body = image.asRequestBody()
                )
            )
            if (response.isSuccessful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.PlainText(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.unknown_error))
            }
        } catch (e: IOException) {
            Resource.Error(message = UiText.StringResource(R.string.server_connection_error))
        } catch (e: HttpException) {
            Resource.Error(message = UiText.StringResource(R.string.something_went_wrong))
        }
    }

    override suspend fun updateProfileInfo(
        username: String?,
        bio: String?,
        profileImage: File?,
        bannerImage: File?
    ): Resource<Unit> {
        val userData = UpdateProfileData(username,bio)
        return try {
            val response = profileRemoteDataSource.updateProfile(
                bannerImage = bannerImage?.let {
                    MultipartBody.Part
                        .createFormData(
                            "banner_image",
                            bannerImage.name,
                            bannerImage.asRequestBody()
                        )
                },
                profilePicture = profileImage?.let {
                    MultipartBody.Part
                        .createFormData(
                            "profile_picture",
                            profileImage.name,
                            profileImage.asRequestBody()
                        )
                },
                updateProfileData = MultipartBody.Part
                    .createFormData(
                        "update_profile_data",
                        gson.toJson(userData)
                    )
            )
            if(response.isSuccessful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.PlainText(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.unknown_error))
            }
        } catch(e: IOException) {
            Resource.Error(
                message = UiText.StringResource(R.string.server_connection_error)
            )
        } catch(e: HttpException) {
            Resource.Error(
                message = UiText.StringResource(R.string.something_went_wrong)
            )
        }
    }

}