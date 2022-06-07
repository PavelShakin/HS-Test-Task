package com.example.hstesttask.di

import com.example.hstesttask.data.database.LocalDataSrcImpl
import com.example.hstesttask.data.remote.ApiClient
import com.example.hstesttask.data.remote.RemoteDataSrcImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceImplModule {

    @Singleton
    @Provides
    fun provideLocalDataSrcImpl(): LocalDataSrcImpl = LocalDataSrcImpl()

    @Singleton
    @Provides
    fun provideRemoteDataSrcImpl(client: ApiClient): RemoteDataSrcImpl = RemoteDataSrcImpl(client)
}