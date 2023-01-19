package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.network.ApiService
import com.llama.petmilly_client.data.network.LibraryApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    val BASE_URL = "https://newsapi.org/v2/"

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun LibraryApiSerVice() : LibraryApiService{
        return Retrofit.Builder()
            .baseUrl("http://openapi.seoul.go.kr:8088/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibraryApiService::class.java)
    }

}