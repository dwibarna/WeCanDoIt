package com.sobarna.success.core.di

import android.content.Context
import com.sobarna.success.core.data.MovieRepository
import com.sobarna.success.core.data.source.local.LocalDataSource
import com.sobarna.success.core.data.source.local.room.MovieDatabase
import com.sobarna.success.core.data.source.remote.RemoteDataSource
import com.sobarna.success.core.data.source.remote.network.ApiConfig
import com.sobarna.success.core.domain.repository.IMovieRepository
import com.sobarna.success.core.domain.usecase.MovieInteract
import com.sobarna.success.core.domain.usecase.MovieUseCase
import com.sobarna.success.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): IMovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideMovieUseCase(context: Context): MovieUseCase {
        val repository = provideRepository(context)
        return MovieInteract(repository)
    }
}
