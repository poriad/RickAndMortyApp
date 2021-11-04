package com.example.rickandmortyapp.di

import com.example.rickandmortyapp.core.RetrofitHelper
import com.example.rickandmortyapp.data.network.RickAndMortyApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NetworkModule.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRickAndMortyApiClient(retrofit: Retrofit) : RickAndMortyApiClient {
        return retrofit.create(RickAndMortyApiClient::class.java)
    }
}