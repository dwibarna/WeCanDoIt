package com.sobarna.sobarnamovies.viewmodel

import android.app.Activity
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX
import com.sobarna.sobarnamovies.sources.MovieAndShowRepository
import com.sobarna.sobarnamovies.utils.DataMoviesAndShow
import com.sobarna.sobarnamovies.utils.JsonHelper
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
class MovieAndShowViewModelTest {
    private lateinit var movieAndShowViewModel: MovieAndShowViewModel
    private lateinit var context: Context
    private val mockitoWebServer = MockWebServer()


    @Mock
    private lateinit var repository: MovieAndShowRepository

    @Mock
    private lateinit var jsonHelper: JsonHelper

    @Mock
    private lateinit var observer: Observer<List<Result>>

    @Mock
    private lateinit var observerX: Observer<List<ResultX>>

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
    fun getMutableMovie() {
        val entities = DataMoviesAndShow.getMoviesData()
        val movieMutable = MutableLiveData<List<Result>>()
        movieMutable.value = entities
        assertEquals(movieMutable.value,entities)

        `when`(repository.getMovies()).thenReturn(movieMutable)
        val moviesEntities = movieAndShowViewModel.getMutable().value

        verify(repository).getMovies()
        assertNotNull(entities)
        assertNotNull(moviesEntities)

        movieAndShowViewModel.getMutable().observeForever(observer)
        verify(observer).onChanged(entities)

    }

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

    @Test
    fun getMutableShow(){
        val entities = DataMoviesAndShow.getShowsData()
        val showMutable = MutableLiveData<List<ResultX>>()
        showMutable.value = entities
        assertEquals(showMutable.value,entities)

        `when`(repository.getShows()).thenReturn(showMutable)
        val showEntities = movieAndShowViewModel.getMutableShow().value

        verify(repository).getShows()
        assertNotNull(entities)
        assertNotNull(showEntities)

        movieAndShowViewModel.getMutableShow().observeForever(observerX)
        verify(observerX).onChanged(entities)
    }
}

