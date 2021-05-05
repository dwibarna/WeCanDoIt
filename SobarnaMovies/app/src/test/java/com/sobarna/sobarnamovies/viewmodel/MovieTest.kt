package com.sobarna.sobarnamovies.viewmodel

import android.app.Activity
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sobarna.sobarnamovies.model.Result
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
class MovieTest {
    private lateinit var movieAndShowViewModel: MovieAndShowViewModel
    private lateinit var context: Context
    private val mockitoWebServer = MockWebServer()


    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var jsonHelper: JsonHelper

    @Mock
    private lateinit var observer: Observer<List<Result>>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun before(){
        mockitoWebServer.start()

        movieAndShowViewModel = MovieAndShowViewModel(repository)
        val activity = Activity()
        context = activity
    }


    @Test
    fun getMutable() {
        val entities = movieAndShowViewModel.getListMovies(context){}
        val movieMutable = MutableLiveData<List<Result>>()
        movieMutable.value = entities
        assertEquals(movieMutable.value,entities)


        repository.getMovies()

        verify(repository).getMovies()
        assertNotNull(entities)

      //  movieMutable.value = entities




    }
/*
    @Test
    fun movieRepository() {
        `when`(repository.getMovies()).thenReturn(ArrayList())

        val entities:List<Result> = movieAndShowViewModel.movieRepository()
        verify(repository).getMovies()
        assertNotNull(entities)
        assertEquals(entities.size, repository.getMovies().size)

    }


 */
    @Test
    fun getListMovies() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)

        mockitoWebServer.enqueue(response)
        val getMovies = movieAndShowViewModel.getListMovies(context){
            ArrayList<Result>()
        }
    val reader = jsonHelper.loadMovies()
    assertNotNull(reader.size)
    assertNotNull(getMovies)
    assertEquals(getMovies.size,reader.size)


    }
}

