package com.thangadurai.animeapp.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.thangadurai.animeapp.ui.theme.statusBarColor


@Composable
fun SetNormalStatusBarColor() {
    rememberSystemUiController().apply {
        setSystemBarsColor(MaterialTheme.colors.statusBarColor)
    }
}
