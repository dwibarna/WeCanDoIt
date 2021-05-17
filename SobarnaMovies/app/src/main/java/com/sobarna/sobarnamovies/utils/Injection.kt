package com.sobarna.sobarnamovies.utils

import android.content.Context
import com.sobarna.sobarnamovies.sources.MovieAndShowRepository
import com.sobarna.sobarnamovies.sources.RemoteDataSource

object Injection {

    fun provideRepository(context: Context): MovieAndShowRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieAndShowRepository.getInstance(remoteDataSource)
    }
}