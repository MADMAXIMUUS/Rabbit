package ru.madmax.rabbit.data.util

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {

    const val BASE_URL = "http://10.0.2.2:8000/"
    const val USER_PREFERENCES = "user_preferences"

    val USER_ID = stringPreferencesKey("user_id")
    val TOKEN = stringPreferencesKey("token")

}