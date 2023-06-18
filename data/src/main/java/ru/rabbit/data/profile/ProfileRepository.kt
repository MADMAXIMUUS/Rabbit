package ru.rabbit.data.profile

import ru.rabbit.data.util.Resource
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