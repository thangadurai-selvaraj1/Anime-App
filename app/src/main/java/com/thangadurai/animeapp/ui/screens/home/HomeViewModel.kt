package com.thangadurai.animeapp.ui.screens.home

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
class HomeViewModel @Inject constructor(
    private val heroRepo: HeroRepo
) : ViewModel() {

    private val _getAllHeroes = MutableStateFlow<PagingData<HeroResponse>>(PagingData.empty())
    val getAllHeroes = _getAllHeroes.asStateFlow()

    init {
        getAllHeroes()
    }

    fun getAllHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            heroRepo.getAllHeroes().cachedIn(viewModelScope).collect {
                _getAllHeroes.value = it
            }
        }
    }
}