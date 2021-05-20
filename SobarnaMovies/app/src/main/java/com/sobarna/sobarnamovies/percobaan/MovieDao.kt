package com.sobarna.sobarnamovies.percobaan

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sobarna.sobarnamovies.model.FavoMovie
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table")
    fun getMovies(): LiveData<List<Result>>

    @Query("SELECT * FROM movie_table where favorite = 1")
    fun getAllFavoriteMovies():LiveData<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie : List<Result>)

    @Update
    fun updateMovies(movie: Result)

    @Transaction
    @Query("SELECT * FROM movie_table WHERE id =:id")
    fun getMovieById(id:Int):LiveData<FavoMovie>






    @Query("SELECT * FROM show_table")
    fun getShows(): LiveData<List<ResultX>>

    @Query("SELECT * FROM show_table where favorite = 1")
    fun getAllFavoriteShows():LiveData<List<ResultX>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(movie : List<Result>)

    @Update
    fun updateShows(movie: Result)

    @Transaction
    @Query("SELECT * FROM movie_table WHERE id =:id")
    fun getMovieById(id:Int):LiveData<FavoMovie>

}