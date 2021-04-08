package com.example.submissionone.model

import com.google.gson.annotations.SerializedName


data class User(
        @SerializedName("login")
        var usernameUser:String,
        @SerializedName("avatar_url")
        var avatarUser:String,
        var id:Int
)

