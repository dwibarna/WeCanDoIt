package com.sobarna.sobarnamovies.percobaan

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sobarna.sobarnamovies.model.Result

@Database(entities = [Result::class], version = 1,exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao():MovieDao

    companion object{

        @Volatile
        private var INSTANCE : MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
            INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movies.db"
                ).build().apply {
                    INSTANCE = this
                }
            }

    }
}