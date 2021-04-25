package com.sohyun.coroutinesampleapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CafeData(
    val title: String,
    val contents: String,
    val url: String,
    val cafename: String,
    val thumbnail: String,
    val datetime: String, // 카페 글 작성시간, ISO 8601 형식, [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
    val like: Boolean
)
