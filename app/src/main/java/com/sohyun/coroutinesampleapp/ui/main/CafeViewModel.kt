package com.sohyun.coroutinesampleapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.data.model.SearchData
import com.sohyun.coroutinesampleapp.data.network.NetworkStatus
import com.sohyun.coroutinesampleapp.data.repository.KakaoCafeRepository
import com.sohyun.coroutinesampleapp.di.DefaultDispatcher
import com.sohyun.coroutinesampleapp.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CafeViewModel @Inject constructor(
    private val kakaoCafeRepository: KakaoCafeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
): ViewModel() {
    val cafeList = MutableLiveData<List<CafeData>>()

    private val showProgressbar = MutableLiveData(false)
    fun showProgressbar() = showProgressbar

    // TODO 이전 검색어 저장 및 다음 검색어와 비교
    suspend fun requestKakaoCafeSearch(query: String) {
        withContext(defaultDispatcher) { kakaoCafeRepository.saveSearchHistoryItem(SearchData(search = query)) }
        val response = withContext(ioDispatcher) { kakaoCafeRepository.getSearchResult(query, 1) }
        when(response) {
            is NetworkStatus.Success -> {
                showProgressbar.value = false
                //
                val list = response.data.documents
                    .map {
                        CafeData(
                            it.title,
                            it.contents,
                            it.url,
                            it.cafename,
                            it.thumbnail,
                            it.datetime,
                            false
                        )
                    }
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

    fun clickLike(item: CafeData) {
        viewModelScope.launch(Dispatchers.Default) { kakaoCafeRepository.likeItem(item) }
    }

    fun removeLike(item: CafeData) {
        viewModelScope.launch(Dispatchers.Default) { kakaoCafeRepository.deleteItem(item) }
    }
}

