package ru.madmax.composetwitterclone.data.profile

import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import ru.madmax.composetwitterclone.data.R
import ru.madmax.composetwitterclone.data.profile.remote.ProfileRemoteDataSource
import ru.madmax.composetwitterclone.data.util.Resource
import ru.madmax.composetwitterclone.util.UiText
import java.io.File
import java.io.IOException
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileRemoteDataSource: ProfileRemoteDataSource
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

}