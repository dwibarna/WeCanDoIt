package com.sobarna.sobarnamovies.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sobarna.sobarnamovies.model.Movies
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.SobanaMovies
import com.sobarna.sobarnamovies.model.SobanaShow
import com.sobarna.sobarnamovies.retrofitapi.ApiRetrofit
import com.sobarna.sobarnamovies.retrofitapi.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieAndShowViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val mutableLive = MutableLiveData<ArrayList<Movies>>()
  //  private val mutableMovie = MutableLiveData<ArrayList<SobanaMovies>>()
    fun getMutable(): LiveData<ArrayList<Result>>{
        return movieRepository.getMovies()
         }

    fun getListShow():List<SobanaShow>{
      return  DataMoviesAndShow.getListShow()
    }
    fun getListMovie():ArrayList<SobanaMovies>{
        return DataMoviesAndShow.getListMovie()
    }

    fun getListMovies(context: Context, unit: (List<Result>) -> Unit) : ArrayList<Result>{
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getListMovie().enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                response.body()?.results?.let { unit(it) }
                mutableLive.postValue(ArrayList())
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
            }

        })
        return ArrayList()
    }


}