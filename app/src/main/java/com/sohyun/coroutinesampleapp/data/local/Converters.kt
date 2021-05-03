package com.sohyun.coroutinesampleapp.data.local

import androidx.room.TypeConverter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    var df: DateFormat = SimpleDateFormat("yyyy mm") // FIXME

    @TypeConverter
    fun fromTimestamp(value: String?): Date? {
        return value?.let { df.parse(it) }
    }

    @TypeConverter
    fun dateToString(date: Date?): String? {
        return date?.time?.toString()
    }
}