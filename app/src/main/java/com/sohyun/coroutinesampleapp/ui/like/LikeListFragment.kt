package com.sohyun.coroutinesampleapp.ui.like

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.databinding.FragmentLikeListBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeListFragment : BaseFragment<FragmentLikeListBinding>(R.layout.fragment_like_list), OnClickedItem {
    private val likeListViewModel: LikeListViewModel by viewModels()
    private lateinit var likeListAdapter: LikeListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            lifecycleOwner = this@LikeListFragment
            viewmodel = likeListViewModel

            likeRecyclerview.run {
                likeListAdapter = LikeListAdapter(this@LikeListFragment)
                adapter = likeListAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            }
        }
    }

    override fun removeItem(cafeData: CafeData) {
        likeListViewModel.removeItem(cafeData)
    }
}