package com.thangadurai.animeapp.ui.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.repo.HeroRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val heroRepo: HeroRepo
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _showLoading = mutableStateOf(false)
    val showLoading = _showLoading

    private val _searchHeroes = MutableStateFlow<PagingData<HeroResponse>>(PagingData.empty())
    val searchHeroes = _searchHeroes.asStateFlow()

    fun onSearchChanged(query: String) {
        _searchQuery.value = query
    }


    fun changeLoadingState(state: Boolean) {
        _showLoading.value = state
    }

    fun onSearchClicked(query: String) {
        changeLoadingState(true)
        viewModelScope.launch(Dispatchers.IO) {
            heroRepo.searchHeroes(query = query).cachedIn(viewModelScope).collect {
                _searchHeroes.value = it
            }
        }
    }
}