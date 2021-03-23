package com.example.submissionone

import com.google.gson.annotations.SerializedName


data class User(
        @SerializedName("login")
        var usernameUser:String?=null,
        @SerializedName("avatar_url")
        var avatarUser:String?=null,
)
data class DetailUser(
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
)
data class DataSearchUser(
        var items:ArrayList<User>
)