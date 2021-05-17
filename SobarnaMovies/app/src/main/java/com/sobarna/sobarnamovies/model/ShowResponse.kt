package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ShowResponse(
    val first_air_date: String,
    val id: Int,
    val name: String,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
):Parcelable