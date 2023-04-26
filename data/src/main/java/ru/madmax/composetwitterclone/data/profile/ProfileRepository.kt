package ru.madmax.composetwitterclone.data.profile

import ru.madmax.composetwitterclone.data.util.Resource
import java.io.File

interface ProfileRepository {

    suspend fun setProfilePhoto(image: File): Resource<Unit>

    suspend fun setProfileBio(
        username: String? = null,
        bio: String? = null,
        profileImage: File? = null,
        bannerImage: File? = null
    ): Resource<Unit>
}