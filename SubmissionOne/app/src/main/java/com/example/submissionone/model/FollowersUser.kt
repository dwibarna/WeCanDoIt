package com.example.submissionone.model

import com.google.gson.annotations.SerializedName

data class FollowersUser (
        @SerializedName("login")
        var usernameUser:String="",
        @SerializedName("avatar_url")
        var avatarUser:String=""
        )