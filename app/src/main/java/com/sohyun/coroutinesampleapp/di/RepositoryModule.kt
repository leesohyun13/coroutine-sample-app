package com.sohyun.coroutinesampleapp.di

import com.sohyun.coroutinesampleapp.data.network.KakaoCafeApi
import com.sohyun.coroutinesampleapp.data.repository.KakaoCafeRepository
import com.sohyun.coroutinesampleapp.data.repository.KakaoCafeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideKakaoCafeRepository(kakaoCafeApi: KakaoCafeApi): KakaoCafeRepository = KakaoCafeRepositoryImpl(kakaoCafeApi)
}