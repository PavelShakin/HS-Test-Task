package com.example.hstesttask.di

import com.example.hstesttask.data.CountriesRepositoryImpl
import com.example.hstesttask.domain.repository.CountriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideCountriesRepository(impl: CountriesRepositoryImpl): CountriesRepository
}