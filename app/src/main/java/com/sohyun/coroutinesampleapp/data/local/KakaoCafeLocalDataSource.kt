package com.sohyun.coroutinesampleapp.data.local

import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.data.model.SearchData
import kotlinx.coroutines.flow.Flow

interface KakaoCafeLocalDataSource {
    fun likeItem(cafe: CafeData)
    fun getLikeList(): Flow<List<CafeData>>
    fun deleteItem(cafe: CafeData)
    fun saveSearchHistoryItem(searchData: SearchData)
    fun deleteSearchHistoryItem(searchData: SearchData)
    fun getSearchHistory(): Flow<List<SearchData>>
}