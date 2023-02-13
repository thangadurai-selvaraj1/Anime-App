package com.thangadurai.animeapp.data.remote

import com.thangadurai.animeapp.data.models.network.ApiResponse
import com.thangadurai.animeapp.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET(ApiConstants.ALL_HEROES_END_POINT)
    suspend fun getAllHeroes(
        @Query(ApiConstants.PAGE_QUERY_KEY) page: Int = 1
    ): ApiResponse

    @GET(ApiConstants.SEARCH_END_POINT)
    suspend fun searchHeroes(
        @Query(ApiConstants.SEARCH_NAME_QUERY_KEY) page: String
    ): ApiResponse
}