package com.thangadurai.animeapp.data.local.dao

import androidx.room.*
import com.thangadurai.animeapp.data.models.network.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRemoteKeys(keys: List<HeroRemoteKey>)

    @Query("delete from hero_remote_table")
    suspend fun deleteAllRemoteKeys()

    @Query("Select * from hero_remote_table where id=:id")
    fun getRemoteKey(id: Int): HeroRemoteKey?

}