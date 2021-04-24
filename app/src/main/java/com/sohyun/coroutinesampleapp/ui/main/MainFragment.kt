package com.sohyun.coroutinesampleapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.databinding.FragmentMainBinding
import com.sohyun.coroutinesampleapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment: BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewModel: CafeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainFragment
            viewmodel = mainViewModel

            searchButton.setOnClickListener {
                lifecycleScope.launch {
                    val cafeList = mainViewModel.requestKakaoCafeSearch(binding.cafeSearchEdittext.text.toString())
                    Log.d("MainFragment", "onCreateView: cafeList ${cafeList}")
                }
            }
        }
    }
}