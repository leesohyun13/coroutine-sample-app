package com.sohyun.coroutinesampleapp.data.network

import com.sohyun.coroutinesampleapp.BuildConfig
import com.sohyun.coroutinesampleapp.data.KakaoSearchSortType
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoCafeApi {
    @GET(SUB_PATH_CAFE)
    suspend fun searchCafe(
        @Header(SCHEMA_REQUEST_HEADER_AUTHORIZATION) restApiKey: String = "KakaoAK ${BuildConfig.KAKAO_CAFE_REST_API_KEY}",
        @Query(SCHEMA_QUERY) query: String,
        @Query(SCHEMA_QUERY_SORT) sort: KakaoSearchSortType?,
        @Query(SCHEMA_QUERY_PAGE) page: Int? = BOOK_STARTING_PAGE_INDEX,
        @Query(SCHEMA_QUERY_SIZE) size: Int = BOOK_PAGING_SIZE,
    ): KaKaoCafeResponse

    companion object {
        const val KAKAO_API_URL = "https://dapi.kakao.com/"

        const val SUB_PATH_CAFE = "v2/search/cafe"
        const val BOOK_STARTING_PAGE_INDEX = 1
        const val BOOK_PAGING_SIZE = 50

        const val SCHEMA_REQUEST_HEADER_AUTHORIZATION = "Authorization"
        const val SCHEMA_QUERY = "query"
        const val SCHEMA_QUERY_SORT = "sort"
        const val SCHEMA_QUERY_PAGE = "page"
        const val SCHEMA_QUERY_SIZE = "size"
    }
}