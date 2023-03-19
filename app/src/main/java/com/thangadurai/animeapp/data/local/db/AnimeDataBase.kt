package com.thangadurai.animeapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.thangadurai.animeapp.data.local.dao.HeroDao
import com.thangadurai.animeapp.data.local.dao.HeroRemoteKeyDao
import com.thangadurai.animeapp.data.models.network.HeroRemoteKey
import com.thangadurai.animeapp.data.models.network.HeroResponse

@Database(
    entities = [HeroResponse::class, HeroRemoteKey::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConvertor::class)
abstract class AnimeDataBase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}