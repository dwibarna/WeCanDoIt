package com.example.submissionone.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorite_table")
class FavoriteUser(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("login")
    var usernameUser:String,
    @SerializedName("avatar_url")
    var avatarUser:String
    )