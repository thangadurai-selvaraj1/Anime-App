package com.thangadurai.animeapp.ui.widgets


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.utils.Dp
import java.net.SocketException

@Composable
fun SearchPlaceholderWidget() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(Dp.d120),
            painter = painterResource(id = R.drawable.search_document),
            contentDescription = "",
        )
        Text(text = stringResource(id =R.string.find_hero), color = Color.LightGray)
    }

}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SearchPlaceholderWidgetDarkPreview() {
    ErrorWidget(LoadState.Error(SocketException()))
}