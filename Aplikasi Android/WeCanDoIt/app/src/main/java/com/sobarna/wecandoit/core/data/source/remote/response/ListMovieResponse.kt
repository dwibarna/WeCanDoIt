package com.sobarna.wecandoit.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sobarna.wecandoit.core.data.source.remote.response.MovieResponse

data class ListMovieResponse(
    @field:SerializedName("results")
    val results: List<MovieResponse>
)