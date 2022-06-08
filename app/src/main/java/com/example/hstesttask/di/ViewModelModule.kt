package com.example.hstesttask.di

import com.example.hstesttask.app.CountriesViewModel
import com.example.hstesttask.domain.usecase.GetCountriesListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object ViewModelModule {

    @Provides
    fun provideCountriesListViewModel(getCountriesListUseCase: GetCountriesListUseCase): CountriesViewModel =
        CountriesViewModel(getCountriesListUseCase)
}