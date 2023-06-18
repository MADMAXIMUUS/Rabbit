package ru.rabbit.data.auth

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import retrofit2.HttpException
import ru.rabbit.data.auth.remote.AuthRemoteDataSource
import ru.rabbit.data.auth.remote.LoginModel
import ru.rabbit.data.auth.remote.SignUpModel
import ru.rabbit.data.util.Constants.TOKEN
import ru.rabbit.data.util.Constants.USER_ID
import ru.rabbit.data.util.Resource
import ru.rabbit.core.util.UiText
import ru.rabbit.data.R
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteSource: AuthRemoteDataSource,
    private val dataStore: DataStore<Preferences>
) : AuthRepository {

    override suspend fun signUp(
        name: String,
        email: String,
        date: Long,
        password: String
    ): Resource<Unit> {
        val signUpModel = SignUpModel(name, email, date, password)
        return try {
            val response = remoteSource.signUp(signUpModel)
            if (response.isSuccessful) {
                response.data?.let { authResponse ->
                    dataStore.edit { preferences ->
                        preferences[USER_ID] = authResponse.userId
                        preferences[TOKEN] = authResponse.token
                    }
                }
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

    override suspend fun signInWithGoogle(): Resource<Unit> {
        return Resource.Success(Unit)
    }

    override suspend fun signIn(email: String, password: String): Resource<Unit> {
        val loginModel = LoginModel(email, password)
        return try {
            val response = remoteSource.login(loginModel)
            if (response.isSuccessful) {
                response.data?.let { authResponse ->
                    dataStore.edit { preferences ->
                        preferences[USER_ID] = authResponse.userId
                        preferences[TOKEN] = authResponse.token
                    }
                }
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

    override suspend fun restorePassword(email: String): Resource<Unit> {
        return try {
            val response = remoteSource.restorePassword(email)
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

    override suspend fun checkCode(code: String): Resource<Unit> {
        return try {
            val response = remoteSource.checkCode(code)
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