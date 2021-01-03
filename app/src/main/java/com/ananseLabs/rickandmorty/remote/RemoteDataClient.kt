package com.ananseLabs.rickandmorty.remote

import com.ananseLabs.rickandmorty.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RemoteDataClient {
    private const val BASE_URL = "http://api.tvmaze.com/"

    private fun getClient(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun getEpisodeClient(): RemoteService {
        return getClient().create(RemoteService::class.java)
    }
}