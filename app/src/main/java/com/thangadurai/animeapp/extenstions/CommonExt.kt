package com.thangadurai.animeapp.extenstions

import androidx.compose.material.*

@OptIn(ExperimentalMaterialApi::class)
fun BottomSheetScaffoldState.currentSheetFraction(): Float {

    val fraction = bottomSheetState.progress.fraction
    val currentValue = bottomSheetState.currentValue
    val targetValue = bottomSheetState.targetValue
    return when {
        currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 1f
        currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 0f
        currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> (1f.minus(
            fraction
        ))
        currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Collapsed -> (0f.plus(
            fraction
        ))

        else -> fraction
    }

}