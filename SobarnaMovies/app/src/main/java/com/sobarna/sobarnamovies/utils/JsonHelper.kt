package com.sobarna.sobarnamovies.utils

import android.content.Context
import com.sobarna.sobarnamovies.model.MovieResponse
import com.sobarna.sobarnamovies.model.ShowResponse
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

    fun loadShows():List<ShowResponse>{
        val showList = ArrayList<ShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()){
                val show = listArray.getJSONObject(i)

                val id = show.getInt("id")
                val name = show.getString("name")
                val overview = show.getString("overview")
                val poster = show.getString("poster_path")
                val firstAirDate = show.getString("first_air_date")
                val language = show.getString("original_language")
                val originalName = show.getString("original_name")
                val popularity = show.getDouble("popularity")
                val vote = show.getDouble("vote_average")
                val count = show.getInt("vote_count")

                val showResponse = ShowResponse(
                    firstAirDate,
                    id,
                    name,
                    language,
                    originalName,
                    overview,
                    popularity,
                    poster,
                    vote,
                    count
                )

                showList.add(showResponse)

            }

        }catch (e:JSONException){
            e.printStackTrace()

        }
        return showList
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
                val language = movie.getString("original_language")
                val originalTitle = movie.getString("original_title")
                val popularity = movie.getDouble("popularity")
                val vote = movie.getDouble("vote_average")
                val count = movie.getInt("vote_count")

                val movieResponse = MovieResponse(
                    id,
                    language,
                    originalTitle,
                    overview,
                    popularity,
                    poster,
                    releaseDate,
                    title,
                    vote,
                    count
                )
                movieList.add(movieResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return movieList
    }


    fun loadModule(courseId: Int): List<MovieResponse> {
        var list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MoviesResponses.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for(i in 0 until listArray.length()){
                val course = listArray.getJSONObject(i)

                val id = course.getInt("id")
                val title = course.getString("title")
                val overview = course.getString("overview")
                val poster = course.getString("poster_path")
                val releaseDate = course.getString("release_date")
                val language = course.getString("original_language")
                val originalTitle = course.getString("original_title")
                val popularity = course.getDouble("popularity")
                val vote = course.getDouble("vote_average")
                val count = course.getInt("vote_count")

                val movieResponse = MovieResponse(id,
                    language,
                    originalTitle,
                    overview,
                    popularity,
                    poster,
                    releaseDate,
                    title,
                    vote,
                    count
                )
                list.add(movieResponse)
            }

        }catch (e:JSONException){
            e.printStackTrace()
        }
        return listOf(list[courseId])
    }


}