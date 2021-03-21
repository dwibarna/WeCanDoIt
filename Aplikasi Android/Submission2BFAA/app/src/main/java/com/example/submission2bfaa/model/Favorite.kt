package com.example.submission2bfaa.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Favorite(
    var username:String?=null,
    var avatar:String?=null,
    var company:String?=null,
    var location:String?=null,
    var repository:String?=null,
    var followers:String?=null,
    var following:String?=null
): Parcelable