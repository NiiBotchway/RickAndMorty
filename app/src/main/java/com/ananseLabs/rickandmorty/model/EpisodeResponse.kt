package com.ananseLabs.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    val id: Int,

    @SerializedName("_embedded")
    val embedded: Embedded
)

data class Embedded(
    val episodes: List<Episode>
)