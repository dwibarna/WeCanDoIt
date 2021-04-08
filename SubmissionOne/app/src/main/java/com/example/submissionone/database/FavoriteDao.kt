package com.example.submissionone.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insertData(favoriteUser: FavoriteUser)

    @Query("SELECT * FROM favorite_table")
    fun getDataFavorite():LiveData<List<FavoriteUser>>

    @Query("DELETE FROM favorite_table WHERE favorite_table.id=:id")
    suspend fun deleteData(id: Int):Int

    @Query("SELECT count(*) FROM favorite_table WHERE favorite_table.id=:id")
    suspend fun checkMyFavorite(id:Int): Int




}