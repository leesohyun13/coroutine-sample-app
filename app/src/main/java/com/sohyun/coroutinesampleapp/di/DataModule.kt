package com.sohyun.coroutinesampleapp.di

import android.app.Application
import com.sohyun.coroutinesampleapp.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideKakaoDb(app: Application) = AppDatabase.invoke(app)

    @Singleton
    @Provides
    fun provideCafeDao(appDatabase: AppDatabase) = appDatabase.cafeDao()

    @Singleton
    @Provides
    fun provideSearchDao(appDatabase: AppDatabase) = appDatabase.searchDao()
}