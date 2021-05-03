package com.sohyun.coroutinesampleapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sohyun.coroutinesampleapp.data.model.SearchData
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {
    @Query("SELECT * FROM search ORDER BY datetime(date) DESC")
    fun getSearchHistory(): Flow<List<SearchData>>

    @Insert
    fun insertItem(item: SearchData)

    @Delete
    fun deleteItem(item: SearchData)
}