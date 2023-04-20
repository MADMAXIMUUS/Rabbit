package ru.madmax.composetwitterclone.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.madmax.composetwitterclone.data.auth.AuthRepository
import ru.madmax.composetwitterclone.data.auth.AuthRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataRepositoryModule {

    @Binds
    fun bindRegistryRepository(
        repositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}