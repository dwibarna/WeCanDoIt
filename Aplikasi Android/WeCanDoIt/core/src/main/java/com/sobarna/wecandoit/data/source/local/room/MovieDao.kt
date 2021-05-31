package com.sobarna.wecandoit.data.source.local.room


import androidx.room.*
import com.sobarna.wecandoit.data.source.local.entity.MovieEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie_table where favorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie:List<MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)

}