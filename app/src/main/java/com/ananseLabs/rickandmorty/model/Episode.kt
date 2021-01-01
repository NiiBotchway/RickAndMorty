package com.ananseLabs.rickandmorty.model

data class Episode (
        val id: Long,
        val url: String,
        val name: String,
        val season: Long,
        val number: Long,
        val type: String,
        val airdate: String,
        val airtime: String,
        val airstamp: String,
        val runtime: Long,
        val image: Image,
        val summary: String
)

data class Image (
    val medium: String,
    val original: String
)