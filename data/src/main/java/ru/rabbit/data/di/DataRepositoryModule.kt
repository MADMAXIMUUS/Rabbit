package ru.rabbit.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.rabbit.data.auth.AuthRepository
import ru.rabbit.data.auth.AuthRepositoryImpl
import ru.rabbit.data.profile.ProfileRepository
import ru.rabbit.data.profile.ProfileRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataRepositoryModule {

    @Binds
    fun bindRegistryRepository(
        repositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    fun bindProfileRepository(
        profileRepositoryImpl: ProfileRepositoryImpl
    ): ProfileRepository

}