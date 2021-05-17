package com.sobarna.sobarnamovies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sobarna.sobarnamovies.sources.MovieAndShowRepository
import com.sobarna.sobarnamovies.utils.Injection

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val repository: MovieAndShowRepository) : ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance:ViewModelFactory? = null

        fun getInstance(context: Context):ViewModelFactory =
                instance ?: synchronized(this){
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

        override fun<T: ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MovieAndShowViewModel::class.java)){
               return MovieAndShowViewModel(repository) as T
            }else{
                throw Throwable("Unknown ViewModel ${modelClass.name}")
            }

        }

}