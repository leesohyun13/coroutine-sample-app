package com.sohyun.coroutinesampleapp.data.repos

import com.sohyun.coroutinesampleapp.data.network.NetworkStatus
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse

interface KakaoCafeRepository {
    suspend fun getSearchResult(query: String, page: Int?): NetworkStatus<KaKaoCafeResponse>
}
