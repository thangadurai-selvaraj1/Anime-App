package com.thangadurai.animeapp.ui.screens.spalsh

import android.content.res.Configuration
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.navigation.Screens
import com.thangadurai.animeapp.ui.theme.splashBgColor
import com.thangadurai.animeapp.utils.Constants
import com.thangadurai.animeapp.utils.Constants.SPLASH_DELAY_DURATION
import com.thangadurai.animeapp.utils.Constants.d360Degree
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.FloatConst
import com.thangadurai.animeapp.utils.SetNormalStatusBarColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    SetNormalStatusBarColor()

    val rotate = remember {
        Animatable(initialValue = FloatConst.f0)
    }

    val isHome by splashViewModel.onBoardFinishClicked.collectAsState()


    LaunchedEffect(key1 = true) {
        rotate.animateTo(
            targetValue = d360Degree,
            animationSpec = tween(
                durationMillis = Constants.SPLASH_ROTATION_DURATION
            )
        )
        delay(SPLASH_DELAY_DURATION)

        navHostController.apply {
            popBackStack()
            if (isHome)
                navigate(Screens.HomeScreen.route)
            else
                navigate(Screens.OnBoardingScreen.route)

        }
    }

    SplashComponent(rotate.value)
}

@Composable
fun SplashComponent(rotate: Float) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashBgColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .rotate(rotate)
        )
        Spacer(modifier = Modifier.height(Dp.d16))
    }
}


@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SplashPreviewDark() {
    SplashComponent(0f)
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun SplashPreviewLight() {
    SplashComponent(0f)
}