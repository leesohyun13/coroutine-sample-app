package com.sohyun.coroutinesampleapp.ui.like

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.databinding.ItemCafeListBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseRecyclerViewAdapter
import com.sohyun.coroutinesampleapp.ui.base.BaseViewHolder
import com.sohyun.coroutinesampleapp.util.changeHtmlToText
import com.sohyun.coroutinesampleapp.util.setDrawableOnView
import com.sohyun.coroutinesampleapp.util.setImageUrlOnView

class LikeListAdapter constructor(
       val onClickedItem: OnClickedItem
): BaseRecyclerViewAdapter<CafeData, LikeListAdapter.CafeHolder>(DiffCallback()) {

    inner class CafeHolder(private val binding: ItemCafeListBinding) :
            BaseViewHolder<CafeData>(binding.root) {
        private lateinit var item: CafeData

        init {
            binding.like.setOnClickListener {
                onClickedItem.removeItem(item)
                removeItem(item)
            }
        }

        override fun bind(item: CafeData) {
            this.item = item
            with(binding) {
                title.text = changeHtmlToText(item.title)
                content.text = changeHtmlToText(item.contents)
                cafename.text = item.cafename
                setImageUrlOnView(thumbnail, item.thumbnail)
                setDrawableOnView(like, R.drawable.baseline_star_black_20)
                executePendingBindings() // 변수 또는 관찰 가능한 객체가 변경될 때 결합은 다음 프레임 이전에 변경을 강제함
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeListAdapter.CafeHolder = CafeHolder(
            ItemCafeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}

private class DiffCallback : DiffUtil.ItemCallback<CafeData>() {
    // 두 객체가 같은 항목인지 확인함
    override fun areItemsTheSame(oldItem: CafeData, newItem: CafeData): Boolean {
        return oldItem.url == newItem.url
    }

    // 두 항목의 데이터가 같은지 확인함
    override fun areContentsTheSame(oldItem: CafeData, newItem: CafeData): Boolean {
        return oldItem == newItem
    }
}