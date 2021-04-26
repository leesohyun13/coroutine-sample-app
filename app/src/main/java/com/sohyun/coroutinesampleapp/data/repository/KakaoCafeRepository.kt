package com.sohyun.coroutinesampleapp.data.repository

import com.sohyun.coroutinesampleapp.data.network.NetworkStatus
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse

interface KakaoCafeRepository {
    suspend fun getSearchResult(query: String, page: Int?): NetworkStatus<KaKaoCafeResponse>
}
