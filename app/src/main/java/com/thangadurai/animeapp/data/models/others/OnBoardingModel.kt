package com.thangadurai.animeapp.data.models.others

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.thangadurai.animeapp.R

sealed class OnBoardingModel(
    @DrawableRes
    val image: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int,
) {
    object First : OnBoardingModel(
        R.drawable.greetings,
        R.string.onBoardFirstTitle,
        R.string.onBoardDescription,
    )

    object Second : OnBoardingModel(
        R.drawable.power,
        R.string.onBoardSecondTitle,
        R.string.onBoardDescription,
    )

    object Third : OnBoardingModel(
        R.drawable.explore,
        R.string.onBoardThirdTitle,
        R.string.onBoardDescription,
    )

}
