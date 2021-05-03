package com.sohyun.coroutinesampleapp.data.repository

import com.sohyun.coroutinesampleapp.data.local.KakaoCafeLocalDataSource
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.data.model.SearchData
import com.sohyun.coroutinesampleapp.data.network.KakaoCafeApi
import com.sohyun.coroutinesampleapp.data.network.NetworkStatus
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KakaoCafeRepositoryImpl @Inject constructor(
        private val kakaoCafeApi: KakaoCafeApi,
        private val localDataSource: KakaoCafeLocalDataSource
) : KakaoCafeRepository, BaseRepository() {
    override suspend fun getSearchResult(
            query: String,
            page: Int?
    ): NetworkStatus<KaKaoCafeResponse> = safeApiCall { kakaoCafeApi.searchCafe(query = query, page = page) }

    override suspend fun likeItem(cafe: CafeData) {
        localDataSource.likeItem(cafe)
    }

    override fun getLikeList(): Flow<List<CafeData>> = localDataSource.getLikeList()

    override suspend fun deleteItem(cafe: CafeData) {
        localDataSource.deleteItem(cafe)
    }

    override suspend fun saveSearchHistoryItem(searchData: SearchData) {
        localDataSource.saveSearchHistoryItem(searchData)
    }

    override fun deleteSearchHistoryItem(searchData: SearchData) {
        localDataSource.deleteSearchHistoryItem(searchData)
    }

    override fun getSearchHistory(): Flow<List<SearchData>> =
            localDataSource.getSearchHistory()
}