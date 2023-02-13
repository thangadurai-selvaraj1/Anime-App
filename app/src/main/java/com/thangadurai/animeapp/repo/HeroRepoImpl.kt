package com.thangadurai.animeapp.repo

import javax.inject.Inject

class HeroRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : HeroRepo {

    override fun getAllHeroes() =
        remoteDataSource.getAllHeroes()

    override fun searchHeroes(query: String) =
        remoteDataSource.searchHeroes(query = query)


}