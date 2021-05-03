package com.sohyun.coroutinesampleapp.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sohyun.coroutinesampleapp.data.model.SearchData
import com.sohyun.coroutinesampleapp.data.repository.KakaoCafeRepository
import com.sohyun.coroutinesampleapp.di.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
        private val kakaoCafeRepository: KakaoCafeRepository,
        @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
): ViewModel() {
    private val _historyList =
            kakaoCafeRepository.getSearchHistory()
            .map { it }
            .asLiveData(
                    viewModelScope.coroutineContext,
                    500
            )
    val historyList: LiveData<List<SearchData>> = _historyList

    fun removeHistoryItem(item: SearchData) {
        viewModelScope.launch(defaultDispatcher) {
            kakaoCafeRepository.deleteSearchHistoryItem(item)
        }
    }
}