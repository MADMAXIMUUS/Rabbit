package ru.rabbit.feature.auth.ui.setProfilePicture

import android.graphics.Bitmap

data class SetProfilePictureScreenState(
    val isButtonEnabled: Boolean = false,
    val isNeedTypeDialog: Boolean = false,
    val photo: Bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565),
    val croppedPhoto: Bitmap? = null,
    val photoWidth: Int = 0,
    val photoHeight: Int = 0,
    val isNeedCropDialog: Boolean = false,
    val isLoading: Boolean = false,
)
