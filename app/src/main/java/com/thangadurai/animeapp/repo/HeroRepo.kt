package com.thangadurai.animeapp.repo

import androidx.paging.PagingData
import com.thangadurai.animeapp.data.models.network.HeroResponse
import kotlinx.coroutines.flow.Flow

interface HeroRepo {
    fun getAllHeroes(): Flow<PagingData<HeroResponse>>
    fun searchHeroes(query: String): Flow<PagingData<HeroResponse>>
}