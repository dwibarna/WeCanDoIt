package com.sobarna.sobarnamovies.viewmodel

import android.content.Context
import com.sobarna.sobarnamovies.model.MovieResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String):String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        }catch (e: IOException){
            e.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse>{
        val movieList = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MoviesResponses.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for(i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val poster = movie.getString("poster_path")
                val releaseDate = movie.getString("release_date")

                val movieResponse = MovieResponse(null,id,null,null,overview,null,poster,releaseDate,title,null,null)

                movieList.add(movieResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return movieList
    }


}