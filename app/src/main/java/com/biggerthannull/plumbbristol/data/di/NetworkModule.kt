package com.biggerthannull.plumbbristol.data.di

import com.biggerthannull.plumbbristol.data.datasource.api.DiscoverApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://www.flickr.com/"
    }

    @Provides
    fun providePhotosApi(): DiscoverApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().apply {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }.build()
            )
            .build()
            .create(DiscoverApi::class.java)
    }
}