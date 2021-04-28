package com.sohyun.coroutinesampleapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sohyun.coroutinesampleapp.data.model.CafeData
import kotlinx.coroutines.flow.Flow

@Dao
interface CafeDao {
    @Query("SELECT * FROM cafe")
    fun getAll(): List<CafeData>

    @Query("SELECT * FROM cafe where `like` LIKE 'true'")
    fun getLikeList(): Flow<List<CafeData>> // 테이블의 데이터가 변경될 때마다 전체 결과 세트를 다시 내보냄

    @Insert
    fun insertItem(vararg cafeData: CafeData)

    @Delete
    fun deleteItem(cafeData: CafeData)
}