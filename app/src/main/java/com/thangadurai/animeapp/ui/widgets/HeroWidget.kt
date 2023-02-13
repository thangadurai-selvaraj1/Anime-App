package com.thangadurai.animeapp.ui.widgets

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.ui.theme.*
import com.thangadurai.animeapp.utils.ApiConstants.BASE_URL
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.FloatConst
import com.thangadurai.animeapp.utils.NumConst.ONE
import com.thangadurai.animeapp.utils.NumConst.THREE
import com.thangadurai.animeapp.utils.Sp

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HeroWidget(
    heroResponse: HeroResponse,
    onClick: (id: Int) -> Unit
) {

    val image = rememberImagePainter(data = "${BASE_URL}${heroResponse.image}") {
        placeholder(R.drawable.placeholder)
        error(R.drawable.placeholder)
        crossfade(enable = true)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dp.d400)
            .padding(Dp.d10)
            .clickable {
                onClick(heroResponse.id)
            }
            .clip(RoundedCornerShape(corner = CornerSize(Dp.d20))),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = image,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            Modifier
                .fillMaxHeight(FloatConst.f0_4)
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = FloatConst.f0_5))
                .padding(top = Dp.d10, bottom = Dp.d10, start = Dp.d20, end = Dp.d10),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Dp.d6)
        ) {
            Text(
                text = heroResponse.name,
                maxLines = ONE,
                color = Color.White,
                fontSize = Sp.s18,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = heroResponse.about,
                color = Color.White,
                fontSize = Sp.s16,
                maxLines = THREE,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Dp.d10)
            ) {
                RatingBarWidget(rating = heroResponse.rating, modifier = Modifier.size(Dp.d24))
                Text(
                    text = "(${heroResponse.rating}/5)",
                    color = Color.White,
                    fontSize = Sp.s16,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun HeroWidgetPreview() {
    HeroWidget(
        heroResponse = HeroResponse(
            1,
            "name",
            image = "",
            about = "some random here..",
            month = "",
            day = "",
            rating = 4.5,
            power = 1,
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        )
    ) {
        println(it)
    }
}


@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun HeroWidgetDarkPreview() {
    HeroWidget(
        heroResponse = HeroResponse(
            1,
            "name",
            image = "",
            about = "some random here..",
            month = "",
            day = "",
            rating = 4.5,
            power = 1,
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        )
    ) {
        println(it)
    }
}