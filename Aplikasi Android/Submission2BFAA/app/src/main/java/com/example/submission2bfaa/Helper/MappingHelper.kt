package com.example.submission2bfaa.Helper

import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.AVATAR
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.COMPANY
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.FOLLOWERS
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.FOLLOWING
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.LOCATION
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.REPOSITORY
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.USERNAME
import android.database.Cursor
import com.example.submission2bfaa.model.Favorite

object MappingHelper {
    fun mapCursorToArrayList(cursor: Cursor?): ArrayList<Favorite> {
        val favList = ArrayList<Favorite>()

        cursor?.apply {
            while (moveToNext()) {
                val username =
                    getString(getColumnIndexOrThrow(USERNAME))
                val avatar =
                    getString(getColumnIndexOrThrow(AVATAR))
                val company =
                    getString(getColumnIndexOrThrow(COMPANY))
                val location =
                    getString(getColumnIndexOrThrow(LOCATION))
                val repository =
                    getString(getColumnIndexOrThrow(REPOSITORY))
                val followers =
                    getString(getColumnIndexOrThrow(FOLLOWERS))
                val following =
                    getString(getColumnIndexOrThrow(FOLLOWING))

                favList.add(
                    Favorite(
                        username,
                        avatar,
                        company,
                        location,
                        repository,
                        followers,
                        following
                    )
                )
            }
        }
        return favList
    }

}