package com.sohyun.coroutinesampleapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.databinding.ItemCafeListBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseRecyclerViewAdapter
import com.sohyun.coroutinesampleapp.ui.base.BaseViewHolder
import com.sohyun.coroutinesampleapp.util.changeHtmlToText
import com.sohyun.coroutinesampleapp.util.setImageOnView

class CafeAdapter: BaseRecyclerViewAdapter<CafeData, CafeAdapter.CafeHolder>() {

    inner class CafeHolder(private val binding: ItemCafeListBinding) :
        BaseViewHolder<CafeData>(binding.root) {
        private lateinit var item: CafeData

        override fun bind(item: CafeData) {
            this.item = item
            with(binding) {
                title.text = changeHtmlToText(item.title)
                content.text = changeHtmlToText(item.contents)
                cafename.text = item.cafename
                setImageOnView(thumbnail, item.thumbnail)
//                executePendingBindings() // 변수 또는 관찰 가능한 객체가 변경될 때 결합은 다음 프레임 이전에 변경을 강제함
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeAdapter.CafeHolder = CafeHolder(
        ItemCafeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}