package com.thangadurai.animeapp.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.Sp

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    biggerText: String,
    smallText: String,
    textColor: Color
) {
    Row(
        modifier = Modifier.padding(end = Dp.d6),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            tint = iconColor,
            modifier = Modifier.size(Dp.d30)
        )
        Spacer(modifier = Modifier.width(Dp.d10))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = biggerText,
                color = textColor,
                fontSize = Sp.s18,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = smallText,
                color = textColor,
                fontSize = Sp.s14,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoBoxPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.bolt),
        biggerText = "98",
        smallText = "Sam",
        iconColor = Color.Magenta,
        textColor = Color.Black
    )
}