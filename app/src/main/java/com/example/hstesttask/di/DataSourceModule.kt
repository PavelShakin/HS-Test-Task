package com.example.hstesttask.di

import com.example.hstesttask.data.database.LocalDataSrcImpl
import com.example.hstesttask.data.datasource.CountriesDatasource
import com.example.hstesttask.data.remote.RemoteDataSrcImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun provideLocalDataSrc(impl: LocalDataSrcImpl): CountriesDatasource.Local

    @Binds
    abstract fun provideRemoteDataSrc(impl: RemoteDataSrcImpl): CountriesDatasource.Remote
}