package com.sohyun.coroutinesampleapp.ui.main

import androidx.lifecycle.ViewModel
import com.sohyun.coroutinesampleapp.data.remote.model.KaKaoCafeResponse
import com.sohyun.coroutinesampleapp.data.repos.KakaoCafeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CafeViewModel @Inject constructor(
    private val kakaoCafeRepository: KakaoCafeRepository
): ViewModel() {

    suspend fun requestKakaoCafeSearch(query: String): KaKaoCafeResponse {
        return kakaoCafeRepository.getSearchResult(query, 1)
    }
}

