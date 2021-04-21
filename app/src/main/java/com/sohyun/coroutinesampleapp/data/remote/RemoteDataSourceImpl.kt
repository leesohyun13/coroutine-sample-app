package com.sohyun.coroutinesampleapp.data.remote

import com.sohyun.coroutinesampleapp.data.KakaoSearchSortType
import com.sohyun.coroutinesampleapp.data.network.KakaoCafeApi
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
        private val kakaoCafeApi: KakaoCafeApi
): RemoteDataSource {
    override suspend fun searchCafes(query: String, page: Int?, sortType: KakaoSearchSortType?): KaKaoCafeResponse {
        return kakaoCafeApi.searchCafe(query = query, page = page, sort = sortType)
    }
}