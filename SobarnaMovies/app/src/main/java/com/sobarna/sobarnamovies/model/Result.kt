package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Entity(tableName = "movie_table")
@Parcelize
data class Result(
        @PrimaryKey(autoGenerate = true)
        @NotNull
        var id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val vote_average: Double,
        val vote_count: Int,
        var favorite:Boolean = false,
) :Parcelable