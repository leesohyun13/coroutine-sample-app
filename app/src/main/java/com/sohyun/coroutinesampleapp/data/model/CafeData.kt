package com.sohyun.coroutinesampleapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "cafe")
@Serializable
data class CafeData(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "contents") val contents: String,
    @PrimaryKey val url: String,
    @ColumnInfo(name = "cafename") val cafename: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "datetime") val datetime: String, // 카페 글 작성시간, ISO 8601 형식, [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
    @ColumnInfo(name = "like") val like: Boolean
)
