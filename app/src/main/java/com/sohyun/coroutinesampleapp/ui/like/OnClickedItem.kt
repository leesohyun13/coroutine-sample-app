package com.sohyun.coroutinesampleapp.ui.like

import com.sohyun.coroutinesampleapp.data.model.CafeData

interface OnClickedItem {
    fun removeItem(cafeData: CafeData)
}