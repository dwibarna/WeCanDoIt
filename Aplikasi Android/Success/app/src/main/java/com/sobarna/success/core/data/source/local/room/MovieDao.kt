package com.sobarna.success.core.data.source.local.room


import androidx.room.*
import com.sobarna.success.core.data.source.local.entity.MovieEntity

import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovie(): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM movie_table where favorite = 1")
    fun getFavoriteMovie(): Flowable<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie:List<MovieEntity>) :Completable

    @Update
    fun updateFavoriteMovie(movie:MovieEntity)

}