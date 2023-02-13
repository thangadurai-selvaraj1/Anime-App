package com.thangadurai.animeapp.ui.widgets

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.FloatConst


@Composable
fun AnimatedShimmerHeroWidget() {
    val transition = rememberInfiniteTransition()

    val alpha by transition.animateFloat(
        initialValue = FloatConst.f1,
        targetValue = FloatConst.f0,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = LinearOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    LoadingHeroWidget(alpha = alpha)

}

@Composable
fun LoadingHeroWidget(alpha: Float) {

    Column {
        repeat(2) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dp.d350)
                    .padding(Dp.d10)
                    .clip(RoundedCornerShape(corner = CornerSize(Dp.d20))),
            ) {
                Column(
                    Modifier
                        .fillMaxHeight(FloatConst.f0_4)
                        .fillMaxWidth()
                        .background(
                            if (isSystemInDarkTheme()) Color.Black else Color.LightGray.copy(
                                alpha = FloatConst.f0_5
                            )
                        )
                        .padding(top = Dp.d10, bottom = Dp.d10, start = Dp.d20, end = Dp.d10),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(FloatConst.f0_5)
                            .height(Dp.d10)
                            .alpha(alpha)
                            .clip(RoundedCornerShape(corner = CornerSize(Dp.d10))),
                        color = Color.LightGray
                    ) {}
                    Spacer(modifier = Modifier.height(Dp.d10))
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(FloatConst.f0_8)
                            .height(Dp.d10)
                            .alpha(alpha)
                            .clip(RoundedCornerShape(corner = CornerSize(Dp.d10))),
                        color = Color.LightGray
                    ) {}
                    Spacer(modifier = Modifier.height(Dp.d10))
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(FloatConst.f0_3)
                            .height(Dp.d10)
                            .alpha(alpha)
                            .clip(RoundedCornerShape(corner = CornerSize(Dp.d10))),
                        color = Color.LightGray
                    ) {}
                    Spacer(modifier = Modifier.height(Dp.d10))
                }
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun LoadingHeroWidgetPreview() {
    AnimatedShimmerHeroWidget()
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun LoadingHeroWidgetDarkPreview() {
    AnimatedShimmerHeroWidget()
}