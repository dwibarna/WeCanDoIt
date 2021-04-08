package com.example.submissionone.model

import com.google.gson.annotations.SerializedName


data class DetailUser(
        @SerializedName("login")
        var usernameUser:String,
        @SerializedName("avatar_url")
        var avatarUser:String,
        @SerializedName("location")
        var locationUser:String,
        @SerializedName("company")
        var companyUser:String,
        @SerializedName("public_repos")
        var repositoryUser:String,
        @SerializedName("followers")
        var followersUser:String,
        @SerializedName("following")
        var followingUser:String,
        @SerializedName("name")
        var nameUser:String
)