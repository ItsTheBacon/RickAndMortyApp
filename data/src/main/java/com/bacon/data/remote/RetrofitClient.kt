package com.bacon.data.remote

import com.bacon.common.constants.Constants.BASE_URL
import com.bacon.data.remote.apiservices.CharacterApiService
import com.bacon.data.remote.apiservices.CharacterDetailApiService
import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.apiservices.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()


    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApiService = provideRetrofit.create(
        CharacterApiService::class.java
    )

    fun provideLocationApiService(): LocationApiService = provideRetrofit.create(
        LocationApiService::class.java
    )

    fun provideEpisodesApiService(): EpisodesApiService = provideRetrofit.create(
        EpisodesApiService::class.java
    )

    fun provideCharacterDetailApiService(): CharacterDetailApiService = provideRetrofit.create(
        CharacterDetailApiService::class.java
    )
}