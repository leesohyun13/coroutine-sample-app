package com.sohyun.coroutinesampleapp.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sohyun.coroutinesampleapp.ui.base.BaseRecyclerViewAdapter
import com.sohyun.coroutinesampleapp.ui.base.BaseViewHolder

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun setImageUrlOnView(view: ImageView, res: String) {
    Glide.with(view.context)
        .load(res)
        .into(view)
}

fun setDrawableOnView(view: ImageView, res: Int) {
    Glide.with(view.context)
        .load(res)
        .into(view)
}

@BindingAdapter("setItems")
fun RecyclerView.setItems(items: List<Any>?) {
    (this.adapter as? BaseRecyclerViewAdapter<Any, BaseViewHolder<Any>>)?.run {
        items?.let { setData(items) }
    }
}