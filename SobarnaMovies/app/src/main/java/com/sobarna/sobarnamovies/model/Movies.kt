package com.sobarna.sobarnamovies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movies(
    val results: List<Result>? = null,
): Parcelable