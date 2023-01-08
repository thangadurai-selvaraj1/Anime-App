package com.thangadurai.animeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.SplashScreen.route
    ) {

        composable(route = Screens.SplashScreen.route) {

        }
        composable(route = Screens.WelcomeScreen.route) {

        }
        composable(route = Screens.HomeScreen.route) {

        }
        composable(
            route = Screens.DetailScreen.route,
            arguments = listOf(navArgument(name = ScreensConstants.HERO_ID_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screens.SearchScreen.route) {

        }
    }
}