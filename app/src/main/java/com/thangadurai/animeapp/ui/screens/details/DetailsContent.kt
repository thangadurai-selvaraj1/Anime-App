package com.thangadurai.animeapp.ui.screens.details

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.extenstions.currentSheetFraction
import com.thangadurai.animeapp.ui.widgets.HeroAbilities
import com.thangadurai.animeapp.ui.widgets.InfoBox
import com.thangadurai.animeapp.utils.ApiConstants
import com.thangadurai.animeapp.utils.Constants
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.Sp

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun DetailsContent(
    hero: HeroResponse?,
    colors: Map<String, String>,
    onCloseClicked: () -> Unit
) {

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val onDarkVibrant = Color(parseColor(colors[Constants.ON_DARK_VIBRANT] ?: "#000000"))
    val darkVibrant = Color(parseColor(colors[Constants.DARK_VIBRANT] ?: "#000000"))
    val vibrant = Color(parseColor(colors[Constants.VIBRANT] ?: "#FFFFFF"))


    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(darkVibrant)

    /*  val animateDp by animateDpAsState(
          targetValue = if (scaffoldState.currentSheetFraction() == 1f) Dp.d20 else 0.dp
      )*/

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = Dp.d150,
        sheetShape = RoundedCornerShape(topEnd = Dp.d20, topStart = Dp.d20),
        sheetContent = {
            hero?.let { response ->
                Column(
                    modifier = Modifier
                        .background(darkVibrant)
                        .padding(Dp.d20),
                ) {
                    TitleWithIconWidget(
                        name = response.name,
                        iconColor = vibrant,
                        textColor = onDarkVibrant
                    )
                    InfoWidget(hero = response, iconColor = vibrant, textColor = onDarkVibrant)
                    AboutWidget(about = response.about, textColor = onDarkVibrant)
                    AbilitiesWidget(hero = response, textColor = onDarkVibrant)
                }

            }

        }
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            val image = rememberImagePainter(data = "${ApiConstants.BASE_URL}${hero?.image}") {
                placeholder(R.drawable.placeholder)
                error(R.drawable.placeholder)
                crossfade(enable = true)
            }
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(scaffoldState.currentSheetFraction() + 0.4f)
                    .align(Alignment.TopCenter)
            )
            IconButton(onClick = {
                onCloseClicked()
            }, modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "",
                    tint = onDarkVibrant
                )
            }
        }
    }
}

@Composable
fun TitleWithIconWidget(
    name: String,
    iconColor: Color = Color.Black,
    textColor: Color = Color.Black
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dp.d10),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            tint = iconColor,
            modifier = Modifier
                .size(Dp.d40)
                .weight(0.15f)
        )
        Spacer(modifier = Modifier.width(Dp.d10))
        Text(
            modifier = Modifier
                .size(Dp.d30)
                .weight(0.8f),
            text = name,
            color = textColor,
            fontSize = Sp.s24,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun InfoWidget(hero: HeroResponse, iconColor: Color = Color.Black, textColor: Color = Color.Black) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dp.d10, vertical = Dp.d16),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        InfoBox(
            icon = painterResource(id = R.drawable.bolt),
            biggerText = hero.power.toString(),
            smallText = stringResource(id = R.string.power),
            iconColor = iconColor,
            textColor = textColor
        )
        InfoBox(
            icon = painterResource(id = R.drawable.cake),
            biggerText = hero.month,
            smallText = stringResource(id = R.string.month),
            iconColor = iconColor,
            textColor = textColor
        )
        InfoBox(
            icon = painterResource(id = R.drawable.calendar),
            biggerText = hero.day,
            smallText = stringResource(id = R.string.birthDay),
            iconColor = iconColor,
            textColor = textColor
        )
    }
}

@Composable
fun AboutWidget(about: String, textColor: Color = Color.Black) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dp.d10),
        text = stringResource(R.string.about),
        color = textColor,
        fontSize = Sp.s18,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = Modifier.height(Dp.d10))
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dp.d10),
        text = about,
        color = textColor,
        fontSize = Sp.s14,
        textAlign = TextAlign.Start
    )
}

@Composable
fun AbilitiesWidget(hero: HeroResponse, textColor: Color = Color.Black) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dp.d10),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        HeroAbilities(
            title = stringResource(id = R.string.family),
            textColor = textColor,
            list = hero.family
        )
        HeroAbilities(
            title = stringResource(id = R.string.abilities),
            textColor = textColor,
            list = hero.abilities
        )
        HeroAbilities(
            title = stringResource(id = R.string.nature),
            textColor = textColor,
            list = hero.natureTypes
        )
    }
}
