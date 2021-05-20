package com.sobarna.sobarnamovies.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sobarna.sobarnamovies.model.*
import com.sobarna.sobarnamovies.percobaan.Resource
import com.sobarna.sobarnamovies.retrofitapi.ApiRetrofit
import com.sobarna.sobarnamovies.retrofitapi.RetrofitClient
import com.sobarna.sobarnamovies.sources.MovieAndShowRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieAndShowViewModel(private val movieRepository: MovieAndShowRepository): ViewModel() {

    private val mutableLiveShow = MutableLiveData<ArrayList<TvShow>>()
    private val mutableLiveMovie = MutableLiveData<ArrayList<Movies>>()

    fun getMutable(): LiveData<Resource<List<Result>>> = movieRepository.getMovies()

    private val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(movId: Int){
        this.movieId.value = movId
    }

    var thisData : LiveData<Resource<FavoMovie>> = Transformations.switchMap(movieId){ corseId ->
        movieRepository.getMoviesWithId(corseId)
    }

   // fun liveData() : LiveData<Resource<Result>>?{
    //    return movieId.value?.let { movieRepository.getMoviesWithId(it) }
   // }

    //var liveingData : LiveData<Resource<Result>>? = movieId.value?.let {
     //   movieRepository.getMoviesWithId(
      //      it
       // )
   // }
 //   fun getMutableCheck(): LiveData<Resource<Result>> = movieRepository.getMoviesWithId(movieId)


   // var liveData: LiveData<Resource<List<Result>>> = movieRepository.getMoviesWithId()


    fun setFavorite(){
        val resource = thisData.value

        if (resource != null){
            val thisis = resource.data

            if (thisis != null){
                val state = !thisis.result.favorite
                movieRepository.setFavoriteMovie(thisis.result, state)
            }
        }
    }


    /*
    fun getMutable(): LiveData<List<Result>>{
        return movieRepository.getMovies()
         }

     */

    fun getMutableShow():LiveData<List<ResultX>>{
        return movieRepository.getShows()
    }

    fun getListShows(context: Context,unit: (List<ResultX>) -> Unit): List<ResultX>{
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getTvShow().enqueue(object : Callback<TvShow> {
            override fun onResponse(call: Call<TvShow>, response: Response<TvShow>) {
                response.body()?.results?.let { unit(it) }
                mutableLiveShow.postValue(ArrayList())
            }
            override fun onFailure(call: Call<TvShow>, t: Throwable) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
            }
        })
        return ArrayList()
    }

    fun getListMovies(context: Context, unit: (List<Result>) -> Unit) : List<Result>{
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getListMovie().enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                response.body()?.results?.let { unit(it) }
                mutableLiveMovie.postValue(ArrayList())
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
            }
        })
        return ArrayList()
    }

        fun getBookmarks(): LiveData<List<Result>> {
            return movieRepository.getBookmarkedCourses()
        }


}