package com.thangadurai.animeapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val StarColor = Color(0xFFFFC94D)


val Colors.splashBgColor
    @Composable
    get() = if (isLight) Purple700 else Color.Black

val Colors.onBoardBgColor
    @Composable
    get() = if (isLight) Color.White else Color.Black


val Colors.titleColor
    @Composable
    get() = if (isLight) Color.Black else Color.White


val Colors.descriptionColor
    @Composable
    get() = if (isLight) Color.Black else Color.White


val Colors.activeColor
    @Composable
    get() = if (isLight) Purple700 else Color.White

val Colors.inActiveColor
    @Composable
    get() = if (isLight) Color.Gray else Color.Gray


val Colors.homeAppbarBgColor
    @Composable
    get() = if (isLight) Purple700 else Color.Black