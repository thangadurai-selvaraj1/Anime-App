package com.thangadurai.animeapp.ui.screens.onBoard

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.data.models.others.OnBoardingModel
import com.thangadurai.animeapp.navigation.Screens
import com.thangadurai.animeapp.ui.theme.*
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.FloatConst
import com.thangadurai.animeapp.utils.Sp

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navHostController: NavHostController,
    onBoardViewModel: OnBoardViewModel = hiltViewModel()
) {

    val pagerList = listOf(
        OnBoardingModel.First,
        OnBoardingModel.Second,
        OnBoardingModel.Third
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onBoardBgColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            count = pagerList.size,
            state = pagerState,
            modifier = Modifier.weight(FloatConst.f10)
        ) { position ->
            PagerScreen(pagerList[position])
        }

        HorizontalPagerIndicator(
            modifier = Modifier.weight(FloatConst.f1),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activeColor,
            inactiveColor = MaterialTheme.colors.inActiveColor,
            spacing = Dp.d10,
        )

        Spacer(modifier = Modifier.height(Dp.d18))

        AnimatedVisibility(visible = pagerState.currentPage == pagerList.size.minus(1)) {
            FinishButton {
                onBoardViewModel.saveOnBoardFinishClicked(true)
                navHostController.apply {
                    popBackStack()
                    navigate(Screens.HomeScreen.route)
                }

            }
        }

        Spacer(modifier = Modifier.height(Dp.d18))
    }

}

@Composable
fun FinishButton(onClick: () -> Unit) {
    Button(
        onClick = onClick, modifier = Modifier
            .fillMaxWidth(FloatConst.f0_5)
            .padding(horizontal = Dp.d10),
        shape = RoundedCornerShape(Dp.d6),
        colors = ButtonDefaults.buttonColors(Purple700)
    ) {
        Text(text = stringResource(R.string.finish), color = Color.White)
    }
}

@Composable
fun PagerScreen(page: OnBoardingModel) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(FloatConst.f0_7)
            .padding(Dp.d20)
    ) {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = stringResource(id = R.string.app_name),
        )
        Spacer(modifier = Modifier.height(Dp.d10))
        Text(
            text = stringResource(id = page.title),
            color = MaterialTheme.colors.titleColor,
            fontSize = Sp.s18,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Dp.d10))
        Text(
            text = stringResource(id = page.description),
            color = MaterialTheme.colors.descriptionColor,
            fontSize = Sp.s14,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PagerScreenPreviewDark() {
    PagerScreen(OnBoardingModel.First)
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun PagerScreenPreviewLight() {
    PagerScreen(OnBoardingModel.First)
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun FinishButtonPreviewLight() {
    FinishButton {}
}