package com.thangadurai.animeapp.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens(ScreensConstants.SPLASH_SCREEN)
    object WelcomeScreen : Screens(ScreensConstants.WELCOME_SCREEN)
    object HomeScreen : Screens(ScreensConstants.HOME_SCREEN)
    object DetailScreen : Screens(ScreensConstants.DETAIL_SCREEN) {
        fun passHeroID(heroId: Int): String {
            return "${ScreensConstants.DETAIL_SCREEN}/$heroId"
        }
    }

    object SearchScreen : Screens(ScreensConstants.SEARCH_SCREEN)
}
