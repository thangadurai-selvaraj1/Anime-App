package com.thangadurai.animeapp.ui.widgets

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.ui.theme.StarColor
import com.thangadurai.animeapp.utils.Dp

@Composable
fun RatingBarWidget(
    rating: Double,
    scaleFactor: Float = 3f,
    maxStar: Int = 5,
    modifier: Modifier
) {

    val starPathString = stringResource(id = R.string.start_path_data)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }

    val starPathBound = remember {
        starPath.getBounds()
    }

    val emptyStars = maxStar.minus(rating).toInt()
    val halfStar = rating.toString().split(".")

    Row(horizontalArrangement = Arrangement.spacedBy(Dp.d10)) {
        for (i in 1..rating.toInt()) {
            FilledStar(
                starPath,
                starPathBound,
                modifier = modifier,
                scaleFactor = scaleFactor,
                color = StarColor
            )
        }
        if (halfStar.last().toInt() > 0)
            HalfFilledStar(
                starPath,
                starPathBound,
                modifier = modifier,
                scaleFactor = scaleFactor,
                color = StarColor
            )
        for (i in 1..emptyStars) {
            FilledStar(
                starPath, starPathBound,
                modifier = modifier,
                scaleFactor = scaleFactor,
                color = Color.Gray,
            )
        }

    }


}

@Composable
fun FilledStar(
    path: Path,
    bound: Rect,
    modifier: Modifier,
    scaleFactor: Float,
    color: Color = Color.Yellow,
) {

    Canvas(modifier = modifier) {
        scale(scaleFactor) {
            val top = (size.width / 2f) - (bound.height / 1.7f)
            val left = (size.width / 2f) - (bound.width / 1.7f)
            translate(
                top = top,
                left = left
            ) {
                drawPath(path = path, color = color)
            }
        }
    }
}

@Composable
fun HalfFilledStar(
    path: Path,
    bound: Rect,
    modifier: Modifier,
    scaleFactor: Float,
    color: Color = Color.Yellow,
) {

    Canvas(modifier = modifier) {
        scale(scaleFactor) {
            val top = (size.width / 2f) - (bound.height / 1.7f)
            val left = (size.width / 2f) - (bound.width / 1.7f)
            translate(
                top = top,
                left = left
            ) {
                drawPath(path = path, color = Color.LightGray.copy(alpha = 0.5f))
                clipPath(
                    path
                ) {
                    drawRect(
                        color = color,
                        size = Size(
                            width = bound.maxDimension / 1.7f,
                            height = bound.maxDimension * scaleFactor
                        )
                    )

                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun RatingBarWidgetPreview() {
    RatingBarWidget(0.5, maxStar = 5, modifier = Modifier.size(30.dp))
}