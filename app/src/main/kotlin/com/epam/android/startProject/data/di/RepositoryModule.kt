package com.epam.android.startProject.data.di

import com.epam.android.startProject.data.repository.CatsRepository
import com.epam.android.startProject.data.repository.CatsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindCatsRepository(repository: CatsRepositoryImpl): CatsRepository
}