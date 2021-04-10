package com.example.consumersubmissionapp

import android.database.Cursor

object MappingHelper {
    fun mapCursor(cursor: Cursor?):ArrayList<FavoriteUser>{
        val list = ArrayList<FavoriteUser>()
        if (cursor != null){
            while (cursor.moveToNext()){
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.ConsumerFavoriteColumns.ID))
                val username = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.ConsumerFavoriteColumns.USERNAME))
                val avatar = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.ConsumerFavoriteColumns.AVATAR))

                list.add(FavoriteUser(id,username,avatar))
            }
        }
        return list
    }
}