package com.sohyun.coroutinesampleapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sohyun.coroutinesampleapp.data.network.NetworkStatus
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.data.repos.KakaoCafeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CafeViewModel @Inject constructor(
    private val kakaoCafeRepository: KakaoCafeRepository
): ViewModel() {
    val cafeList = MutableLiveData<List<CafeData>>()

    private val showProgressbar = MutableLiveData(false)
    fun showProgressbar() = showProgressbar

    suspend fun requestKakaoCafeSearch(query: String) {
        val responses = kakaoCafeRepository.getSearchResult(query, 1)
        when(responses) {
            is NetworkStatus.Success -> {
                showProgressbar.value = false
                //
                val list = responses.data.documents
                    .map { CafeData(it.title, it.contents, it.url, it.cafename, it.thumbnail, it.datetime, false) } // FIXME
                    .toList()
                cafeList.postValue(list)
            }
            is NetworkStatus.Failure -> {
                // TODO show error
                showProgressbar.value = false
            }
            is NetworkStatus.Loading -> {
                showProgressbar.value = true
            }
        }
    }
}

