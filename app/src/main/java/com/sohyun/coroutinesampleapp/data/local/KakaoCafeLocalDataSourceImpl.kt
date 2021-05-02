package com.sohyun.coroutinesampleapp.data.local

import com.sohyun.coroutinesampleapp.data.model.CafeData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KakaoCafeLocalDataSourceImpl @Inject constructor(
        private val cafeDao: CafeDao
) : KakaoCafeLocalDataSource {
    override fun likeItem(cafe: CafeData) {
        cafeDao.insertItem(cafe)
    }

    override fun getLikeList(): Flow<List<CafeData>> =
            cafeDao.getLikeList()

    override fun deleteItem(cafe: CafeData) {
        cafeDao.deleteItem(cafe)
    }
}