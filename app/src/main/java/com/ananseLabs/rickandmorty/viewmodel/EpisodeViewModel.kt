package com.ananseLabs.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import com.ananseLabs.rickandmorty.model.EpisodeResponse
import com.ananseLabs.rickandmorty.remote.RemoteDataClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {
    fun getEpisodes(callback: ResponseCallback) {

        val call = RemoteDataClient.getEpisodeClient().getEpisodes()

        call.enqueue(object : Callback<EpisodeResponse> {
            override fun onResponse(
                call: Call<EpisodeResponse>,
                response: Response<EpisodeResponse>
            ) {
                callback.execute(response.body())
            }

            override fun onFailure(call: Call<EpisodeResponse>, t: Throwable) {
                t.printStackTrace()
                callback.execute(t.localizedMessage)
            }

        })

    }
}

interface ResponseCallback {
    fun execute(data: Any?)
}