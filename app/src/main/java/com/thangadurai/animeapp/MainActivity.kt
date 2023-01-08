package com.thangadurai.animeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thangadurai.animeapp.navigation.SetupNavGraph
import com.thangadurai.animeapp.ui.theme.AnimeAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeAppTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navHostController = navHostController)
            }
        }
    }
}
