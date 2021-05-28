package com.sobarna.goodapp.core.domain.usecase

import com.sobarna.goodapp.core.data.Resource
import com.sobarna.goodapp.core.domain.model.Movie
import io.reactivex.Flowable

interface MovieUseCase {
    fun getAllMovie(): Flowable<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flowable<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}