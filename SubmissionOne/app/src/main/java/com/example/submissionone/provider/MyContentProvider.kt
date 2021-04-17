package com.example.submissionone.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.submissionone.database.FavoriteDao
import com.example.submissionone.database.FavoriteDatabase

class MyContentProvider : ContentProvider() {

    companion object{
        const val TABLE_NAME = "favorite_table"
        const val AUTHORITY = "com.example.submissionone"
        const val ID_FAVORITE = 1
        val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        init {
            uriMatcher.addURI(AUTHORITY, TABLE_NAME, ID_FAVORITE)
        }
    }
    private lateinit var favorDao:FavoriteDao

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun onCreate(): Boolean {
        favorDao = context?.let {favorite ->
            FavoriteDatabase.getDatabase(favorite)?.favoriteDao()
        }!!
        return false
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val cursor:Cursor?
        when(uriMatcher.match(uri)){
            ID_FAVORITE -> {
                cursor = favorDao.favoriteAll()
                if (context != null){
                    cursor.setNotificationUri(context?.contentResolver,uri)
                }
            }
            else -> {
                cursor = null
            }
        }
        return cursor
    }
    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }
}