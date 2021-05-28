package com.sobarna.goodapp.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sobarna.goodapp.core.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movie_table where favorite = 1")
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie:List<MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie:MovieEntity)

}