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
        @SerializedName("company")
        var companyUser:String?=null,
        @SerializedName("public_repos")
        var repositoryUser:String?=null,
        @SerializedName("followers")
        var followersUser:String?=null,
        @SerializedName("following")
        var followingUser:String?=null
):Parcelable