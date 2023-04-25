package ru.madmax.composetwitterclone.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.madmax.composetwitterclone.data.auth.remote.AuthRemoteDataSource
import ru.madmax.composetwitterclone.data.profile.remote.ProfileRemoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthRemoteDataSource {
        return retrofit.create(AuthRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileApi(retrofit: Retrofit): ProfileRemoteDataSource {
        return retrofit.create(ProfileRemoteDataSource::class.java)
    }
}