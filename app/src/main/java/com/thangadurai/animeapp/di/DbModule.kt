package com.thangadurai.animeapp.di

import android.content.Context
import androidx.room.Room
import com.thangadurai.animeapp.data.local.db.AnimeDataBase
import com.thangadurai.animeapp.utils.DatabaseConstants.ANIME_APP_DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AnimeDataBase {
        return Room.databaseBuilder(
            context,
            AnimeDataBase::class.java,
            ANIME_APP_DB_NAME
        ).build()
    }

}