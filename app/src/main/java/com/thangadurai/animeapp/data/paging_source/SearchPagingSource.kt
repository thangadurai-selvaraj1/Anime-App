package com.thangadurai.animeapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.data.remote.AnimeApiService
import javax.inject.Inject

class SearchPagingSource
@Inject constructor(
    private val animeApiService: AnimeApiService,
    private val query: String,
) : PagingSource<Int, HeroResponse>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HeroResponse> {
        return try {
            val response = animeApiService.searchHeroes(query)
            if (response.heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = response.heroes,
                    prevKey = response.prevPage,
                    nextKey = response.nextPage
                )
            } else {
                LoadResult.Page(
                    data = response.heroes,
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HeroResponse>) = state.anchorPosition

}