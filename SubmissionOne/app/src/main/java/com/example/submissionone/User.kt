package com.example.submissionone

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
        @SerializedName("login")
        var usernameUser:String?=null,
        @SerializedName("avatar_url")
        var avatarUser:String?=null,
        @SerializedName("location")
        var locationUser:String?=null,
        var companyUser:String?=null,
        var repositoryUser:String?=null,
        var followersUser:String?=null,
        var followingUser:String?=null
):Parcelable