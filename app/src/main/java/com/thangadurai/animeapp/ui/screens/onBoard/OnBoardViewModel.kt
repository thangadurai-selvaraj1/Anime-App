package com.thangadurai.animeapp.ui.screens.onBoard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thangadurai.animeapp.data.pref.PrefKeys
import com.thangadurai.animeapp.data.pref.PrefStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(private val prefStore: PrefStore) : ViewModel() {

    fun saveOnBoardFinishClicked(clicked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            prefStore.saveValue(PrefKeys.KEY_FINISH_CLICKED, value = clicked)
        }
    }
}