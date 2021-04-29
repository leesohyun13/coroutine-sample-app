package com.sohyun.coroutinesampleapp.ui.main

import com.sohyun.coroutinesampleapp.data.model.CafeData

interface OnClickItem {
    fun clickLike(isLike: Boolean, item: CafeData)
}