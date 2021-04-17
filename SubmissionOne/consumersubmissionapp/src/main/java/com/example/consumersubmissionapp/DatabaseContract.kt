package com.example.consumersubmissionapp

import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {

    const val AUTHORITY = "com.example.submissionone"
    const val SCHEME = "content"

    internal class ConsumerFavoriteColumns:BaseColumns{
        companion object{
            const val TABLE_NAME = "favorite_table"
            const val ID = "id"
            const val USERNAME = "usernameUser"
            const val AVATAR = "avatarUser"

            val CONTENT_URI : Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}