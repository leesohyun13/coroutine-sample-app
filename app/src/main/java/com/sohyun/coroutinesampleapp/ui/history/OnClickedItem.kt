package com.sohyun.coroutinesampleapp.ui.history

import com.sohyun.coroutinesampleapp.data.model.SearchData

interface OnClickedItem {
    fun removeHistoryItem(searchData: SearchData)
}