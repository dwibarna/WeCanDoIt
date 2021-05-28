package com.sobarna.goodapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sobarna.goodapp.core.data.source.local.entity.MovieEntity

data class ListMovieResponse(
    @field:SerializedName("results")
    val results: List<MovieResponse>
)