package com.sohyun.coroutinesampleapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "search")
@Serializable
data class SearchData(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val search: String,
        val date: String
)
