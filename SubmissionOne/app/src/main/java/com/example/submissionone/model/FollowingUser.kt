package com.example.submissionone.model

import com.google.gson.annotations.SerializedName

data class FollowingUser (
        @SerializedName("login")
        var usernameUser:String="",
        @SerializedName("avatar_url")
        var avatarUser:String=""
)

