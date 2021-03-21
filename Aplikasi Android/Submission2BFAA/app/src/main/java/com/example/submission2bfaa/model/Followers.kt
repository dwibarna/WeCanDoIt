package com.example.submission2bfaa.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Followers (
    var username:String?=null,
    var avatar:String?=null,
    var followers:String?=null,
    var dataFollowing:String?=null
): Parcelable