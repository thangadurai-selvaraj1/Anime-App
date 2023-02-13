package com.thangadurai.animeapp.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.navigation.Screens
import com.thangadurai.animeapp.ui.widgets.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    var isRef by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            HomeTopAppBar {
                navHostController.navigate(
                    Screens.SearchScreen.route
                )
            }
        },
        content = {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = isRef),
                swipeEnabled = allHeroes.itemCount == 0,
                onRefresh = {
                    isRef = true
                    allHeroes.refresh()
                    isRef = false
                }) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    allHeroes.apply {
                        when (loadState.refresh) {
                            is LoadState.Loading -> item {
                                AnimatedShimmerHeroWidget()
                            }
                            is LoadState.NotLoading -> items(
                                items = allHeroes,
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
                                    ) {
                                        /*navHostController.navigate(
                                            Screens.SplashScreen.route
                                        )*/
                                    }
                                }
                            }
                            is LoadState.Error -> item {
                                ErrorWidget(loadState.refresh as LoadState.Error)
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

        }
    )

}