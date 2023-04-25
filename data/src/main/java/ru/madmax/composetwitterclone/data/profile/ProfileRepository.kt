package ru.madmax.composetwitterclone.data.profile

import android.graphics.Bitmap
import retrofit2.http.Url
import ru.madmax.composetwitterclone.data.util.Resource
import java.io.File

interface ProfileRepository {

    suspend fun setProfilePhoto(image: File): Resource<Unit>
}