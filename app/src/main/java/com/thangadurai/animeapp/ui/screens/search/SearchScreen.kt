package com.thangadurai.animeapp.ui.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.navigation.Screens
import com.thangadurai.animeapp.ui.widgets.*
import com.thangadurai.animeapp.utils.SetNormalStatusBarColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    navHostController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel()
) {

    SetNormalStatusBarColor()

    val searchHeroes = viewModel.searchHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchAppBar(
                text = viewModel.searchQuery.value,
                onChanged = {
                    viewModel.onSearchChanged(it)
                    if (it.isNotEmpty())
                        viewModel.onSearchClicked(it)
                },
                onCloseClicked = {
                    navHostController.popBackStack()
                },
                onSearchClicked = {
                    if (it.isNotEmpty())
                        viewModel.onSearchClicked(it)
                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                searchHeroes.apply {
                    when (loadState.refresh) {
                        is LoadState.Loading -> item {
                            if (viewModel.showLoading.value)
                                AnimatedShimmerHeroWidget()
                            if (searchHeroes.itemCount == 0)
                                SearchPlaceholderWidget()
                        }
                        is LoadState.NotLoading -> {
                            viewModel.changeLoadingState(state = false)
                            if (searchHeroes.itemCount == 0) {
                                item {
                                    EmptyWidget()
                                }
                            } else {
                                items(
                                    items = searchHeroes,
                                    key = { it.id }) { heroes ->
                                    heroes?.let {
                                        HeroWidget(
                                            heroResponse = HeroResponse(
                                                id = it.id,
                                                name = it.name,
                                                image = it.image,
                                                about = it.about,
                                                month = it.month,
                                                day = it.day,
                                                rating = it.rating,
                                                power = it.power,
                                                family = it.family,
                                                abilities = it.abilities,
                                                natureTypes = it.natureTypes,
                                            )
                                        ) { id ->
                                            navHostController.navigate(
                                                Screens.DetailScreen.passHeroID(id)
                                            )
                                        }
                                    }
                                }
                            }

                        }
                        is LoadState.Error -> {
                            viewModel.changeLoadingState(state = false)
                            item {
                                ErrorWidget(loadState.refresh as LoadState.Error)
                            }
                        }
                    }

                    when (loadState.append) {
                        LoadState.Loading ->
                            item {
                                PagingLoadingWidget()
                            }
                        else -> Unit
                    }
                }
            }
        }
    )
}