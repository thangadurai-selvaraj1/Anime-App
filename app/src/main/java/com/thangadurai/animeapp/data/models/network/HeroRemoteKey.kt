package com.thangadurai.animeapp.data.models.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thangadurai.animeapp.utils.DatabaseConstants.HERO_REMOTE_TABLE_NAME

@Entity(tableName = HERO_REMOTE_TABLE_NAME)
data class HeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prePage:Int?,
    val nextPage:Int?,
    val lastUpdated: Long?
)
