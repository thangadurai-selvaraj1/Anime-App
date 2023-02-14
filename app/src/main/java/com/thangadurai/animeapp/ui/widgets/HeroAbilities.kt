package com.thangadurai.animeapp.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.Sp

@Composable
fun HeroAbilities(
    title: String,
    textColor: Color,
    list: List<String>
) {
    LazyColumn(
        modifier = Modifier
            .padding(end = Dp.d6)
    ) {
        item {
            Text(
                text = title,
                color = textColor,
                fontSize = Sp.s18,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dp.d10))
        }
        itemsIndexed(items = list) { index, title ->
            Text(
                text = "${index + 1}.$title",
                color = textColor,
                fontSize = Sp.s14,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HeroAbilitiesPreview() {
    HeroAbilities(
        title = "Hero",
        textColor = Color.Black,
        list = listOf("sample", "sample", "sample")
    )
}