package ru.madmax.composetwitterclone.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.madmax.composetwitterclone.data.auth.remote.AuthRemoteSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthRemoteSource {
        return retrofit.create(AuthRemoteSource::class.java)
    }
}