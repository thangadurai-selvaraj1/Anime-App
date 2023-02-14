package com.thangadurai.animeapp.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.navigation.ScreensConstants.HERO_ID_KEY
import com.thangadurai.animeapp.repo.HeroRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val heroRepo: HeroRepo,
    onSavedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _hero = MutableStateFlow<HeroResponse?>(null)
    val hero = _hero.asStateFlow()

    private val _palateColor = MutableStateFlow<Map<String, String>>(mapOf())
    val palateColor = _palateColor.asStateFlow()


    init {
        val id = onSavedStateHandle.get<Int>(HERO_ID_KEY) ?: -1
        getSingleHero(id)
    }

    private fun getSingleHero(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            if (id != -1) {
                heroRepo.getSingleHero(id).collect {
                    _hero.value = it
                }
            }
        }
    }

    fun setColorPalate(map: Map<String, String>) {
        viewModelScope.launch(Dispatchers.IO) {
            _palateColor.value = map
        }
    }
}