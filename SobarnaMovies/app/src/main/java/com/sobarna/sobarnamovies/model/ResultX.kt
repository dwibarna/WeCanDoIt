package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "show_table")
@kotlinx.parcelize.Parcelize
data class ResultX(
    val first_air_date: String,
    @PrimaryKey(autoGenerate = true)
    @NotNull
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