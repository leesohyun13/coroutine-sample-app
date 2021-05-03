package com.sohyun.coroutinesampleapp.data.repository

import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.data.model.SearchData
import com.sohyun.coroutinesampleapp.data.network.NetworkStatus
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse
import kotlinx.coroutines.flow.Flow

interface KakaoCafeRepository {
    suspend fun getSearchResult(query: String, page: Int?): NetworkStatus<KaKaoCafeResponse>
    suspend fun likeItem(cafe: CafeData)
    fun getLikeList(): Flow<List<CafeData>>
    suspend fun deleteItem(cafe: CafeData)
    suspend fun saveSearchHistoryItem(searchData: SearchData)
    fun deleteSearchHistoryItem(searchData: SearchData)
    fun getSearchHistory(): Flow<List<SearchData>>
}
