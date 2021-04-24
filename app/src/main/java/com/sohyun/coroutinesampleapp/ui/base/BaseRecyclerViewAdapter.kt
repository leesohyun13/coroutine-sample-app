package com.sohyun.coroutinesampleapp.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T, H : BaseViewHolder<T>> :
    RecyclerView.Adapter<H>() {

    private val items: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    open fun setData(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}