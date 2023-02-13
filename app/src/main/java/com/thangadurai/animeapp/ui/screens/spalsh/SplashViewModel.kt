package com.thangadurai.animeapp.ui.screens.spalsh

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thangadurai.animeapp.data.pref.PrefKeys
import com.thangadurai.animeapp.data.pref.PrefStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val prefStore: PrefStore) : ViewModel() {

    private val _onBoardFinishClicked = MutableStateFlow(false)
    val onBoardFinishClicked: StateFlow<Boolean> = _onBoardFinishClicked

    init {
        getOnBoardFinishClicked()
    }

    private fun getOnBoardFinishClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            _onBoardFinishClicked.value =
                prefStore.getValue(PrefKeys.KEY_FINISH_CLICKED).stateIn(viewModelScope).value == true
        }
    }
}