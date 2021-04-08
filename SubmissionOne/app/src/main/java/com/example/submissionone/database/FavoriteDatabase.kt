package com.example.submissionone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(
    entities = [FavoriteUser::class],
    version = 1
)
abstract class FavoriteDatabase:RoomDatabase() {

    abstract fun favoriteDao():FavoriteDao

    companion object{

        private var INSTANCE:FavoriteDatabase? = null

        fun getDatabase(context: Context): FavoriteDatabase? {
            if(INSTANCE == null ){
                synchronized(FavoriteDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteDatabase::class.java,
                        "favorite_database"
                    ).build()
                }
            }
            return INSTANCE
        }

    }


}