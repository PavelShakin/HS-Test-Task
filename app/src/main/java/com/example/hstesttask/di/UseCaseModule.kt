package com.example.hstesttask.di

import com.example.hstesttask.domain.usecase.GetCountriesListUseCase
import com.example.hstesttask.domain.usecase.GetCountriesListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun provideGetCountriesUseCase(impl: GetCountriesListUseCaseImpl): GetCountriesListUseCase
}