package com.sohyun.coroutinesampleapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sohyun.coroutinesampleapp.data.model.CafeData

@Database(entities = [CafeData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cafeDao(): CafeDao

    companion object {
        private const val DATABASE_NAME = "kakao-cafe.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        // 데이터베이스 생성시 단일 스레드에서만 작업하고, lock 걸림
        operator fun invoke(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}