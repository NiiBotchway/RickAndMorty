package com.ananseLabs.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.ananseLabs.rickandmorty.R
import com.ananseLabs.rickandmorty.adapter.EpisodeAdapter
import com.ananseLabs.rickandmorty.model.Episode
import com.ananseLabs.rickandmorty.model.EpisodeResponse
import com.ananseLabs.rickandmorty.viewmodel.EpisodeViewModel
import com.ananseLabs.rickandmorty.viewmodel.ResponseCallback
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: EpisodeViewModel
    private lateinit var adapter: EpisodeAdapter
    private lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(EpisodeViewModel::class.java)
        initView()
        getEpisodes()
    }

    private fun getEpisodes() {
        viewModel.getEpisodes(object: ResponseCallback {
            override fun execute(data: Any?) {
                data?.let {
                    when(it){
                        is EpisodeResponse -> {
                            adapter = EpisodeAdapter(it.embedded.episodes)
                            recyclerview.adapter = adapter
                        }
                        is String -> {
                            Snackbar.make(recyclerview, it, Snackbar.LENGTH_SHORT).show()
                        }
                    }

                }
            }

        })
    }

    private fun initView() {
        recyclerview = findViewById(R.id.rv_episode_list_view)
    }
}