package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class SobanaMovies(
        var avatarMovie: Int,
        var movieTitle: String,
        var releaseDateMovie: String,
        var genreMovie:String,
        var overviewMovie:String,
        var directorMovie:String,

):Parcelable

