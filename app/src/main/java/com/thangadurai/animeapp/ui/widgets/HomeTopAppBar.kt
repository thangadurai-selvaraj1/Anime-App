package com.thangadurai.animeapp.ui.widgets

import android.content.res.Configuration
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.ui.theme.homeAppbarBgColor


@Composable
fun HomeTopAppBar(
    title: String = stringResource(id = R.string.onBoardThirdTitle),
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.homeAppbarBgColor,
        contentColor = Color.White,
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeTopAppBarPreviewLight() {
    HomeTopAppBar {

    }
}