package com.sobarna.goodapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.sobarna.goodapp.core.data.Resource
import com.sobarna.goodapp.core.domain.model.Movie
import io.reactivex.Flowable

interface IMovieRepository {

    fun getAllMovies(): Flowable<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flowable<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

}