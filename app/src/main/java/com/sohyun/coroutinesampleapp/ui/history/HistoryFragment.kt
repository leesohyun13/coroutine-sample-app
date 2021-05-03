package com.sohyun.coroutinesampleapp.ui.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.databinding.FragmentHistoryBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseFragment

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var historyAdapter: HistoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            lifecycleOwner = this@HistoryFragment
            viewmodel = historyViewModel

            historyRecyclerview.run {
                historyAdapter = HistoryAdapter()
                adapter = historyAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            }
        }
    }
}