package com.thangadurai.animeapp.navigation

import com.thangadurai.animeapp.navigation.ScreensConstants.HERO_ID_KEY

sealed class Screens(val route: String) {
    object SplashScreen : Screens(ScreensConstants.SPLASH_SCREEN)
    object OnBoardingScreen : Screens(ScreensConstants.ON_BOARDING_SCREEN)
    object HomeScreen : Screens(ScreensConstants.HOME_SCREEN)
    object DetailScreen : Screens("${ScreensConstants.DETAIL_SCREEN}/{${HERO_ID_KEY}}") {
        fun passHeroID(heroId: Int): String {
            return "${ScreensConstants.DETAIL_SCREEN}/$heroId"
        }
    }

    object SearchScreen : Screens(ScreensConstants.SEARCH_SCREEN)
}
