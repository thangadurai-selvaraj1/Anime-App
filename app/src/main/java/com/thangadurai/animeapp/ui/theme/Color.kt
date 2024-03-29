package com.thangadurai.animeapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val StarColor = Color(0xFFFFC94D)


val Colors.splashBgColor
    get() = if (isLight) Purple700 else Color.Black

val Colors.onBoardBgColor
    get() = if (isLight) Color.White else Color.Black


val Colors.titleColor
    get() = if (isLight) Color.Black else Color.White


val Colors.descriptionColor
    get() = if (isLight) Color.Black else Color.White


val Colors.activeColor
    get() = if (isLight) Purple700 else Color.White

val Colors.inActiveColor
    get() = if (isLight) Color.Gray else Color.Gray


val Colors.homeAppbarBgColor
    get() = if (isLight) Purple700 else Color.Black


val Colors.statusBarColor
    get() = if (isLight) Purple700 else Color.Black