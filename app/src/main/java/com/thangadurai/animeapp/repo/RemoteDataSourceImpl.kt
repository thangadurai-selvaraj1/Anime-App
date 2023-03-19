package com.thangadurai.animeapp.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.thangadurai.animeapp.data.local.db.AnimeDataBase
import com.thangadurai.animeapp.data.models.network.HeroResponse
import com.thangadurai.animeapp.data.paging_source.HeroRemoteMediator
import com.thangadurai.animeapp.data.paging_source.SearchPagingSource
import com.thangadurai.animeapp.data.remote.AnimeApiService
import com.thangadurai.animeapp.utils.Constants.PAGE_SIZE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val animeApiService: AnimeApiService,
    private val animeDataBase: AnimeDataBase
) : RemoteDataSource {

    private val heroDao = animeDataBase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<HeroResponse>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            remoteMediator = HeroRemoteMediator(
                animeApi = animeApiService,
                animeDatabase = animeDataBase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<HeroResponse>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                SearchPagingSource(
                    animeApiService = animeApiService,
                    query = query
                )
            }
        ).flow
    }
}
