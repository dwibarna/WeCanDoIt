package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SobanaShow(
        var avatarShow:Int,
        var showTitle:String,
        var ReleaseDateShow:String,
        var genreShow:String,
        var overviewShow:String,
        var directorShow:String

): Parcelable