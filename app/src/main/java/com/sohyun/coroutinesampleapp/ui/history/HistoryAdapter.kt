package com.sohyun.coroutinesampleapp.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.sohyun.coroutinesampleapp.data.model.SearchData
import com.sohyun.coroutinesampleapp.databinding.ItemHistoryListBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseRecyclerViewAdapter
import com.sohyun.coroutinesampleapp.ui.base.BaseViewHolder

class HistoryAdapter : BaseRecyclerViewAdapter<SearchData, HistoryAdapter.ViewHolder>(DiffCallback()) {
    inner class ViewHolder(private val binding: ItemHistoryListBinding) : BaseViewHolder<SearchData>(binding.root) {
        private lateinit var item: SearchData

        init {
            // Remove item
            binding.close.setOnClickListener {  }
        }

        override fun bind(item: SearchData) {
            this.item = item
            with(binding) {
                searchText.text = item.search
                time.text = item.date
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolder = ViewHolder(
            ItemHistoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}

private class DiffCallback : DiffUtil.ItemCallback<SearchData>() {
    // 두 객체가 같은 항목인지 확인함
    override fun areItemsTheSame(oldItem: SearchData, newItem: SearchData): Boolean {
        return oldItem.id == newItem.id
    }

    // 두 항목의 데이터가 같은지 확인함
    override fun areContentsTheSame(oldItem: SearchData, newItem: SearchData): Boolean {
        return oldItem == newItem
    }
}