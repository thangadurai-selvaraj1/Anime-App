package com.thangadurai.animeapp.data.models.network

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success:Boolean,
    val message:String?,
    val prevPage:Int?,
    val nextPage:Int?,
    val heroes:List<HeroResponse> = emptyList(),
    val lastUpdated: Long?
)