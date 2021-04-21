package com.sohyun.coroutinesampleapp.data.remote

import com.sohyun.coroutinesampleapp.data.KakaoSearchSortType
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse

interface RemoteDataSource {
    suspend fun searchCafes(query: String, page: Int?, sortType: KakaoSearchSortType?): KaKaoCafeResponse
}