package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MovieResponse(
        val id: Int,
        val original_language: String,
        val original_title: String ,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val vote_average: Double,
        val vote_count: Int
) : Parcelable
