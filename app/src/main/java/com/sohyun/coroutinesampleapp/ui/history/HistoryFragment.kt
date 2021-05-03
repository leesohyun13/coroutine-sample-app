package com.sohyun.coroutinesampleapp.ui.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.data.model.SearchData
import com.sohyun.coroutinesampleapp.databinding.FragmentHistoryBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history), OnClickedItem {
    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var historyAdapter: HistoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            lifecycleOwner = this@HistoryFragment
            viewmodel = historyViewModel

            historyRecyclerview.run {
                historyAdapter = HistoryAdapter(this@HistoryFragment)
                adapter = historyAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            }
        }
    }

    override fun removeHistoryItem(searchData: SearchData) {
        historyViewModel.removeHistoryItem(searchData)
    }
}