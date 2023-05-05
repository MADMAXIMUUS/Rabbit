package ru.madmax.rabbit.data.profile

import ru.madmax.rabbit.data.util.Resource
import java.io.File

interface ProfileRepository {

    suspend fun setProfilePhoto(image: File): Resource<Unit>

    suspend fun updateProfileInfo(
        username: String? = null,
        bio: String? = null,
        profileImage: File? = null,
        bannerImage: File? = null
    ): Resource<Unit>
}