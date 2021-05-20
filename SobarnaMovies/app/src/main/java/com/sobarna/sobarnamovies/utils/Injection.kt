package com.sobarna.sobarnamovies.utils

import android.content.Context
import com.sobarna.sobarnamovies.percobaan.AppExecutors
import com.sobarna.sobarnamovies.percobaan.LocalDataSource
import com.sobarna.sobarnamovies.percobaan.MovieDatabase
import com.sobarna.sobarnamovies.sources.MovieAndShowRepository
import com.sobarna.sobarnamovies.sources.RemoteDataSource

object Injection {

    fun provideRepository(context: Context): MovieAndShowRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()


        return MovieAndShowRepository.getInstance(remoteDataSource,localDataSource,appExecutors)
    }
}