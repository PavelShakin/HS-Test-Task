package com.example.hstesttask.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.example.hstesttask.BuildConfig
import com.example.hstesttask.data.remote.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().apply {
        connectTimeout(40, TimeUnit.SECONDS)
        writeTimeout(40, TimeUnit.SECONDS)
        readTimeout(40, TimeUnit.SECONDS)
        addInterceptor(interceptor)
    }.build()

    @Singleton
    @Provides
    fun provideService(okHttpClient: OkHttpClient): ApolloClient = ApolloClient.Builder()
        .serverUrl(BuildConfig.BASE_URL)
        .okHttpClient(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiClient() = ApiClient()
}