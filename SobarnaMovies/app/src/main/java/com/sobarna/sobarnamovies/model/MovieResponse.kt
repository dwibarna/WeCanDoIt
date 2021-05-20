package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize
class MovieResponse(
        @NotNull
        @PrimaryKey(autoGenerate = true)
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
