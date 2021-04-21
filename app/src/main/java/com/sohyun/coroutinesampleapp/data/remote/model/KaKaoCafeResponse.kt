package com.sohyun.coroutinesampleapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class KaKaoCafeResponse(
    @SerializedName("documents")
    val documents: List<Document>,
    @SerializedName("meta")
    val meta: Meta
) {
    data class Meta(
        @SerializedName("total_count")
        val totalCount: Int,
        @SerializedName("pageable_count")
        val pageableCount: Int,
        @SerializedName("is_end")
        val isEnd: Boolean // 값이 false면 page를 증가시켜 다음 페이지를 요청할 수 있음
    )
    data class Document(
        @SerializedName("title")
        val title: String,
        @SerializedName("contents")
        val contents: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("cafename")
        val cafename: String,
        @SerializedName("thumbnail")
        val thumbnail: String,
        @SerializedName("datetime")
        val datetime: String // 카페 글 작성시간, ISO 8601 형식, [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
    )
}