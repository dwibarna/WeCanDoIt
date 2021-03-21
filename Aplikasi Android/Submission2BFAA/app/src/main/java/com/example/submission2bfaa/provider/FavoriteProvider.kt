package com.example.submission2bfaa.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.submission2bfaa.Helper.FavoriteHelper
import com.example.submission2bfaa.db.DatabaseContract.Companion.AUTHORITY
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.CONTENT_URI
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.TABLE_NAME

class FavoriteProvider: ContentProvider() {

    companion object {
        private const val FAV = 1
        private const val FAV_ID = 2
        private lateinit var favoriteHelper: FavoriteHelper
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

        init {
            uriMatcher.addURI(AUTHORITY, TABLE_NAME, FAV)
            uriMatcher.addURI(
                AUTHORITY, "${TABLE_NAME}/#",
                FAV_ID
            )
        }
    }


    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val insert: Long = when (FAV) {
            uriMatcher.match(uri) -> favoriteHelper.insert(values)
            else -> 0
        }
        context?.contentResolver?.notifyChange(CONTENT_URI, null)
        return Uri.parse("$CONTENT_URI/$insert")
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            FAV -> favoriteHelper.queryAll()
            FAV_ID -> favoriteHelper.queryById(uri.lastPathSegment.toString())
            else -> null
        }
    }

    override fun onCreate(): Boolean {
        favoriteHelper = FavoriteHelper.getInstance(context as Context)
        favoriteHelper.open()
        return true
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        val updated: Int = when (FAV_ID) {
            uriMatcher.match(uri) -> favoriteHelper.update(
                uri.lastPathSegment.toString(),
                values!!
            )
            else -> 0
        }
        context?.contentResolver?.notifyChange(CONTENT_URI, null)
        return updated
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val deleted: Int = when (FAV_ID) {
            uriMatcher.match(uri) -> favoriteHelper.deleteById(uri.lastPathSegment.toString())
            else -> 0
        }
        context?.contentResolver?.notifyChange(CONTENT_URI, null)
        return deleted
    }

    override fun getType(uri: Uri): String? {
        return null
    }
}