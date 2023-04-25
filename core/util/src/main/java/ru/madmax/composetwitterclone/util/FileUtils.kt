package ru.madmax.composetwitterclone.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date

object FileUtils {

    @SuppressLint("SimpleDateFormat")
    fun createImageFile(context: Context): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val directory = File(context.cacheDir, "images")
        directory.mkdirs()
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            directory
        )
    }

    fun bitmapToFile(context: Context, bitmap: Bitmap): File? {
        var file: File? = null
        return try {
            file = createImageFile(context)
            val bos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, bos)
            val bitmapData = bos.toByteArray()

            //write the bytes in file
            val fos = FileOutputStream(file)
            fos.write(bitmapData)
            fos.flush()
            fos.close()
            file
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.e("BitmapToFile", it) }
            file
        }
    }
}