package com.thangadurai.animeapp.di

import androidx.paging.ExperimentalPagingApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.thangadurai.animeapp.data.local.db.AnimeDataBase
import com.thangadurai.animeapp.data.remote.AnimeApiService
import com.thangadurai.animeapp.repo.HeroRepo
import com.thangadurai.animeapp.repo.HeroRepoImpl
import com.thangadurai.animeapp.repo.RemoteDataSource
import com.thangadurai.animeapp.repo.RemoteDataSourceImpl
import com.thangadurai.animeapp.utils.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get(ApiConstants.CONTENT_TYPE)
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(ApiConstants.READ_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(ApiConstants.READ_TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideAnimeApiService(retrofit: Retrofit): AnimeApiService {
        return retrofit.create(AnimeApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideRemoteDataSource(
        animeApiService: AnimeApiService,
        animeDataBase: AnimeDataBase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            animeApiService = animeApiService,
            animeDataBase = animeDataBase
        )
    }


    @Provides
    @Singleton
    fun provideHeroRepo(
        remoteDataSource: RemoteDataSource,
        animeDataBase: AnimeDataBase
    ): HeroRepo {
        return HeroRepoImpl(
            remoteDataSource = remoteDataSource,
            heroDao = animeDataBase.heroDao()
        )
    }

}