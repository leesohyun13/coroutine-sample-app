package com.sohyun.coroutinesampleapp.ui.main

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

class CafeAdapter constructor(val clickedListener: OnClickedItem): BaseRecyclerViewAdapter<CafeData, CafeAdapter.CafeHolder>(DiffCallback()) {

    inner class CafeHolder(private val binding: ItemCafeListBinding) :
        BaseViewHolder<CafeData>(binding.root) {
        private lateinit var item: CafeData

        init {
            binding.like.setOnClickListener {
                item.like = !item.like
                if (item.like) setDrawableOnView(binding.like, R.drawable.baseline_star_black_20) else setDrawableOnView(binding.like, R.drawable.baseline_star_border_black_20)
                clickedListener.clickLike(!item.like, item)
            }
        }

        override fun bind(item: CafeData) {
            this.item = item
            with(binding) {
                title.text = changeHtmlToText(item.title)
                content.text = changeHtmlToText(item.contents)
                cafename.text = item.cafename
                // FIXME Load failed for  with size [240x240]
                setImageUrlOnView(thumbnail, item.thumbnail)
                if (item.like) setDrawableOnView(like, R.drawable.baseline_star_black_20) else setDrawableOnView(like, R.drawable.baseline_star_border_black_20)
                executePendingBindings() // 변수 또는 관찰 가능한 객체가 변경될 때 결합은 다음 프레임 이전에 변경을 강제함
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeAdapter.CafeHolder = CafeHolder(
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