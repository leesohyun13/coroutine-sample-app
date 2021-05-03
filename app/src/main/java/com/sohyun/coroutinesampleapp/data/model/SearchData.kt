package com.sohyun.coroutinesampleapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.*

@Entity(tableName = "search")
@Serializable
data class SearchData(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val search: String,
        val date: Long = Calendar.getInstance().time.time
)
