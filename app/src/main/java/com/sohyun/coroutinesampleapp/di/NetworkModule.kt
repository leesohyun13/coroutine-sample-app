package com.sohyun.coroutinesampleapp.di

import com.sohyun.coroutinesampleapp.data.network.KakaoCafeApi
import com.sohyun.coroutinesampleapp.data.network.KakaoCafeApi.Companion.KAKAO_API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideKakaoApi(): KakaoCafeApi {
        return Retrofit.Builder()
            .baseUrl(KAKAO_API_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KakaoCafeApi::class.java)
    }
}