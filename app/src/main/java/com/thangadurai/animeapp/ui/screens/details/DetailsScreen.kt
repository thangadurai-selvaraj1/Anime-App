package com.thangadurai.animeapp.ui.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thangadurai.animeapp.utils.ApiConstants
import com.thangadurai.animeapp.utils.PaletteGenerator

@Composable
fun DetailsScreen(
    navHostController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {

    val hero by detailsViewModel.hero.collectAsState()
    val palateColor by detailsViewModel.palateColor.collectAsState()
    val context = LocalContext.current

    hero?.image?.let { image ->
        LaunchedEffect(key1 = image) {
            PaletteGenerator.convertImageUrlToBitmap(
                "${ApiConstants.BASE_URL}${image}",
                context
            )?.let { bitmap ->
                detailsViewModel.setColorPalate(
                    PaletteGenerator.extractColorsFromBitmap(
                        bitmap
                    )
                )
            }
        }
    }


    DetailsContent(
        hero = hero,
        colors = palateColor,
        onCloseClicked = {
            navHostController.popBackStack()
        },
    )
}