package com.ananseLabs.rickandmorty.remote

import com.ananseLabs.rickandmorty.model.EpisodeResponse
import retrofit2.Call
import retrofit2.http.GET

interface RemoteService {

    @GET("shows/216?embed=episodes")
    fun getEpisodes() : Call<EpisodeResponse>

}