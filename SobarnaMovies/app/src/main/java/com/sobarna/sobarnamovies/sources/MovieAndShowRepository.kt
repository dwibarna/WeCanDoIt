package com.sobarna.sobarnamovies.sources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sobarna.sobarnamovies.model.*
import com.sobarna.sobarnamovies.percobaan.*

class MovieAndShowRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
):
    MovieAndShowSource {

    companion object{
        @Volatile
        private var instance: MovieAndShowRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource,localData: LocalDataSource, appExecutors: AppExecutors): MovieAndShowRepository =
                instance ?: synchronized(this){
                    instance ?: MovieAndShowRepository(remoteDataSource,localData,appExecutors).apply { instance = this }
                }
    }

    override fun getMovies(): LiveData<Resource<List<Result>>> {
        return object : NetworkBoundResource<List<Result>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<Result>> =
                localDataSource.getAllMovies()
            override fun shouldFetch(data: List<Result>?): Boolean =
                data == null || data.isEmpty()
            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovies()
            public override fun saveCallResult(courseResponses: List<MovieResponse>) {
                val courseList = ArrayList<Result>()
                for (response in courseResponses) {
                    val course = Result(
                        response.id,
                        response.original_language,
                        response.original_title,
                        response.overview,
                        response.popularity,
                        response.poster_path,
                        response.release_date,
                        response.title,
                        response.vote_average,
                        response.vote_count,
                        false
                    )
                    courseList.add(course)
                }

                localDataSource.insertMovies(courseList)
            }
        }.asLiveData()
    }

    override fun getMoviesWithId(movieId: Int): LiveData<Resource<FavoMovie>> {
        return object : NetworkBoundResource<FavoMovie, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<FavoMovie> {
                return localDataSource.getMoviesWithId(movieId)
            }

            override fun shouldFetch(data: FavoMovie?): Boolean {
                return data?.listResult == null || data. listResult.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getMoviesById(movieId)
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<Result>()
                for(response in data){
                    val entity = Result(
                        response.id,
                        response.original_language,
                        response.original_title,
                        response.overview,
                        response.popularity,
                        response.poster_path,
                        response.release_date,
                        response.title,
                        response.vote_average,
                        response.vote_count,
                        false
                    )

                    movieList.add(entity)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getShows(): LiveData<List<ResultX>> {
        val showResult = MutableLiveData<List<ResultX>>()
        remoteDataSource.getShows(object : RemoteDataSource.LoadShowCallback {
            override fun onAllShowReceived(showResponse: List<ShowResponse>) {
                val showList = ArrayList<ResultX>()
                for (response in showResponse){
                    val show = ResultX(response.first_air_date,response.id,response.name,response.original_language,response.original_name,response.overview,response.popularity,response.poster_path,response.vote_average,response.vote_count)

                    showList.add(show)
                }
                showResult.postValue(showList)
            }
        })
        return showResult
    }

    override fun setFavoriteMovie(movie: Result, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovies(movie,state) }


    override fun getBookmarkedCourses(): LiveData<List<Result>> =
        localDataSource.getBookmarkedCourses()

}

