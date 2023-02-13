package com.thangadurai.animeapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.thangadurai.animeapp.data.models.network.HeroResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHeroes(heroes: List<HeroResponse>)

    @Query("delete from hero_table")
    suspend fun deleteAllHeroes()

    @Query("Select * from hero_table where id=:heroId")
     fun getSingleHero(heroId: Int): Flow<HeroResponse>

    @Query("Select * from hero_table")
     fun getAllHeroes(): PagingSource<Int, HeroResponse>

}