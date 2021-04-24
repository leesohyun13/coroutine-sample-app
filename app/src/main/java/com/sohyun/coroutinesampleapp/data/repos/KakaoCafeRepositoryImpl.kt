package com.sohyun.coroutinesampleapp.data.repos

import com.sohyun.coroutinesampleapp.data.network.KakaoCafeApi
import com.sohyun.coroutinesampleapp.data.network.NetworkStatus
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse
import javax.inject.Inject

class KakaoCafeRepositoryImpl @Inject constructor(
    private val kakaoCafeApi: KakaoCafeApi
): KakaoCafeRepository, BaseRepository() {

    override suspend fun getSearchResult(
        query: String,
        page: Int?
    ): NetworkStatus<KaKaoCafeResponse> = safeApiCall { kakaoCafeApi.searchCafe(query = query, page = page) }
}