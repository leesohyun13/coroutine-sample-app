package com.sohyun.coroutinesampleapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.databinding.FragmentMainBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseFragment
import com.sohyun.coroutinesampleapp.util.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment: BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewModel: CafeViewModel by viewModels()
    private lateinit var cafeAdapter: CafeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainFragment
            viewmodel = mainViewModel

            cafeSearchRecyclerview.run {
                cafeAdapter = CafeAdapter()
                adapter = cafeAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            }

            searchButton.setOnClickListener {
                hideKeyboard()
                lifecycleScope.launch {
                    mainViewModel.requestKakaoCafeSearch(binding.cafeSearchEdittext.text.toString())
                }
            }
        }
    }
}