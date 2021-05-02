package com.sohyun.coroutinesampleapp.ui.like

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sohyun.coroutinesampleapp.data.model.CafeData
import com.sohyun.coroutinesampleapp.data.repository.KakaoCafeRepository
import com.sohyun.coroutinesampleapp.di.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikeListViewModel @Inject constructor(
        private val kakaoCafeRepository: KakaoCafeRepository,
        @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _likeList =
            kakaoCafeRepository.getLikeList()
                    .map { it }
                    .asLiveData(
                            viewModelScope.coroutineContext,
                            500
                    )
    val likeList: LiveData<List<CafeData>> = _likeList

    fun removeItem(cafeData: CafeData) {
        viewModelScope.launch(defaultDispatcher) { kakaoCafeRepository.deleteItem(cafeData) }
    }
}