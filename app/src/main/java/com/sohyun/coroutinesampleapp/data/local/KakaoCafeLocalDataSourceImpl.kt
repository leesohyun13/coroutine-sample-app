package com.sohyun.coroutinesampleapp.data.local

import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.data.model.SearchData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KakaoCafeLocalDataSourceImpl @Inject constructor(
        private val cafeDao: CafeDao,
        private val searchDao: SearchDao
) : KakaoCafeLocalDataSource {
    override fun likeItem(cafe: CafeData) {
        cafeDao.insertItem(cafe)
    }

    override fun getLikeList(): Flow<List<CafeData>> =
            cafeDao.getLikeList()

    override fun deleteItem(cafe: CafeData) {
        cafeDao.deleteItem(cafe)
    }

    override fun saveSearchHistoryItem(searchData: SearchData) {
        searchDao.insertItem(searchData)
    }

    override fun deleteSearchHistoryItem(searchData: SearchData) {
        searchDao.deleteItem(searchData)
    }

    override fun getSearchHistory(): Flow<List<SearchData>> =
            searchDao.getSearchHistory()
}