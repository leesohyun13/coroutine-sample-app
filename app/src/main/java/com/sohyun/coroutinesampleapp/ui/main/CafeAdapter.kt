package com.sohyun.coroutinesampleapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.databinding.ItemCafeListBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseRecyclerViewAdapter
import com.sohyun.coroutinesampleapp.ui.base.BaseViewHolder
import com.sohyun.coroutinesampleapp.util.changeHtmlToText
import com.sohyun.coroutinesampleapp.util.setDrawableOnView
import com.sohyun.coroutinesampleapp.util.setImageUrlOnView

class CafeAdapter: BaseRecyclerViewAdapter<CafeData, CafeAdapter.CafeHolder>() {

    inner class CafeHolder(private val binding: ItemCafeListBinding) :
        BaseViewHolder<CafeData>(binding.root) {
        private lateinit var item: CafeData

        init {
            binding.like.setOnClickListener {
                if (item.like) setDrawableOnView(binding.like, R.drawable.baseline_star_black_20) else setDrawableOnView(binding.like, R.drawable.baseline_star_border_black_20)
            }
        }

        override fun bind(item: CafeData) {
            this.item = item
            with(binding) {
                title.text = changeHtmlToText(item.title)
                content.text = changeHtmlToText(item.contents)
                cafename.text = item.cafename
                setImageUrlOnView(thumbnail, item.thumbnail)
                if (item.like) setDrawableOnView(like, R.drawable.baseline_star_black_20) else setDrawableOnView(like, R.drawable.baseline_star_border_black_20)
//                executePendingBindings() // 변수 또는 관찰 가능한 객체가 변경될 때 결합은 다음 프레임 이전에 변경을 강제함
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeAdapter.CafeHolder = CafeHolder(
        ItemCafeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}