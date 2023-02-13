package com.thangadurai.animeapp.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.thangadurai.animeapp.R
import com.thangadurai.animeapp.ui.theme.homeAppbarBgColor
import com.thangadurai.animeapp.utils.Dp
import com.thangadurai.animeapp.utils.FloatConst

@Composable
fun SearchAppBar(
    text: String,
    onChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dp.d54),
        color = MaterialTheme.colors.homeAppbarBgColor,
        elevation = AppBarDefaults.TopAppBarElevation,
        contentColor = Color.White
    ) {
        TextField(
            value = text,
            onValueChange = onChanged,
            trailingIcon = {
                IconButton(onClick = {
                    if (text.isEmpty()) {
                        onCloseClicked()
                    } else {
                        onChanged("")
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            },
            leadingIcon = {
                IconButton(onClick = {
                    onCloseClicked()
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.LightGray.copy(alpha = FloatConst.f0_6)
                    )
                }
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_here),
                    color = Color.LightGray.copy(alpha = FloatConst.f0_5)
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearchClicked(text)
            }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
    }
}