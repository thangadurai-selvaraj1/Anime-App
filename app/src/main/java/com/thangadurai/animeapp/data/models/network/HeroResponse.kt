package com.thangadurai.animeapp.data.models.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thangadurai.animeapp.utils.DatabaseConstants
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = DatabaseConstants.HERO_TABLE_NAME)
data class HeroResponse(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val month: String,
    val day: String,
    val rating: Double,
    val power: Int,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>,
)
