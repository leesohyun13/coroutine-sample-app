package com.sohyun.coroutinesampleapp.di

import com.sohyun.coroutinesampleapp.data.local.KakaoCafeLocalDataSource
import com.sohyun.coroutinesampleapp.data.local.KakaoCafeLocalDataSourceImpl
import com.sohyun.coroutinesampleapp.data.repository.KakaoCafeRepository
import com.sohyun.coroutinesampleapp.data.repository.KakaoCafeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindKakaoCafeRepository(
        kakaoCafeLocalDataSource: KakaoCafeRepositoryImpl
    ): KakaoCafeRepository

    @Binds
    abstract fun bindKakaoCafeLocalDataSource(
        kakaoCafeLocalDataSource: KakaoCafeLocalDataSourceImpl
    ): KakaoCafeLocalDataSource
}