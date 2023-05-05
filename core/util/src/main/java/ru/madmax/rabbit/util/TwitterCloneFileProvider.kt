package ru.madmax.rabbit.util

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider

class TwitterCloneFileProvider: FileProvider(R.xml.file_paths){

    companion object {
        fun getImageUri(context: Context): Uri {
            val file = FileUtils.createTempImageFile(context)
            val authority = context.packageName + ".util.fileProvider"
            return getUriForFile(
                context,
                authority,
                file,
            )
        }
    }

}