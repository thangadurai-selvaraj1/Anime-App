package com.thangadurai.animeapp.repo

import com.thangadurai.animeapp.data.local.dao.HeroDao
import javax.inject.Inject

class HeroRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val heroDao: HeroDao
) : HeroRepo {

    override fun getAllHeroes() =
        remoteDataSource.getAllHeroes()

    override fun searchHeroes(query: String) =
        remoteDataSource.searchHeroes(query = query)

    override fun getSingleHero(id: Int) =
        heroDao.getSingleHero(id)


}