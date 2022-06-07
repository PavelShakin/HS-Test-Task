package com.example.hstesttask.di

import com.example.hstesttask.domain.repository.CountriesRepository
import com.example.hstesttask.domain.usecase.GetCountriesListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCaseImplModule {

    @Provides
    fun provideGetCountriesUseCaseImpl(repository: CountriesRepository): GetCountriesListUseCaseImpl =
        GetCountriesListUseCaseImpl(repository)
}