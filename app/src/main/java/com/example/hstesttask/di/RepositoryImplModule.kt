package com.example.hstesttask.di

import com.example.hstesttask.data.CountriesRepositoryImpl
import com.example.hstesttask.data.datasource.CountriesDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryImplModule {

    @Provides
    fun provideCountriesRepositoryImpl(
        remoteDataSrcImpl: CountriesDatasource.Remote
    ): CountriesRepositoryImpl =
        CountriesRepositoryImpl(remoteDataSrcImpl)
}