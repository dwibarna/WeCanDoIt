package com.sobarna.sobarnamovies.viewmodel

import android.content.Context

object Injection {

    fun provideRepository(context: Context):MovieRepository{
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))


        return MovieRepository.getInstance(remoteDataSource)
    }
}