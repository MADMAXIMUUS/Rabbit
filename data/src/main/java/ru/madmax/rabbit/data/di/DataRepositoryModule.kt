package ru.madmax.rabbit.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.madmax.rabbit.data.auth.AuthRepository
import ru.madmax.rabbit.data.auth.AuthRepositoryImpl
import ru.madmax.rabbit.data.profile.ProfileRepository
import ru.madmax.rabbit.data.profile.ProfileRepositoryImpl

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