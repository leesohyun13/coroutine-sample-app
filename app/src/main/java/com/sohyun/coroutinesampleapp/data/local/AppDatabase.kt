package com.sohyun.coroutinesampleapp.data.local

import androidx.room.Database
import com.sohyun.coroutinesampleapp.data.model.CafeData

@Database(entities = [CafeData::class], version = 1)
abstract class AppDatabase {
    abstract fun cafeDao(): CafeDao
}