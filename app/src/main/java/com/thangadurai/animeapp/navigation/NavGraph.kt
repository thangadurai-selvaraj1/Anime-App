package com.thangadurai.animeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.thangadurai.animeapp.ui.screens.details.DetailsScreen
import com.thangadurai.animeapp.ui.screens.home.HomeScreen
import com.thangadurai.animeapp.ui.screens.onBoard.OnBoardingScreen
import com.thangadurai.animeapp.ui.screens.search.SearchScreen
import com.thangadurai.animeapp.ui.screens.spalsh.SplashScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.SplashScreen.route
    ) {

        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navHostController)
        }
        composable(route = Screens.OnBoardingScreen.route) {
            OnBoardingScreen(navHostController)
        }
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navHostController)
        }
        composable(
            route = Screens.DetailScreen.route,
            arguments = listOf(navArgument(name = ScreensConstants.HERO_ID_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navHostController)
        }
        composable(route = Screens.SearchScreen.route) {
            SearchScreen(navHostController)
        }
    }
}