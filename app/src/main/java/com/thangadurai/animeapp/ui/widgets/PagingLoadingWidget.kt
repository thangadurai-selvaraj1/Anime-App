package com.thangadurai.animeapp.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thangadurai.animeapp.utils.Dp

@Composable
fun PagingLoadingWidget() {
    Box(
        modifier = Modifier
            .padding(Dp.d5)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        CircularProgressIndicator()
    }
}