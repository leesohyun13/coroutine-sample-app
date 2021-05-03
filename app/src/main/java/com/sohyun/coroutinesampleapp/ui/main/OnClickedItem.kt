package com.sohyun.coroutinesampleapp.ui.main

import com.sohyun.coroutinesampleapp.data.model.CafeData

interface OnClickedItem {
    fun clickLike(isLike: Boolean, item: CafeData)
}