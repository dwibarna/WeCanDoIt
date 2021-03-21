package com.example.submissionone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var Username:String?,
    var Name:String?,
    var Avatar:Int?,
    var Location:String?,
    var Company:String?,
    var Repository:String?,
    var Followers:String?,
    var Following:String?
):Parcelable