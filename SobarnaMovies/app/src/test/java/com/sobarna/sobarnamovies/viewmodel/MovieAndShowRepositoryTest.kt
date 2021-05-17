package com.sobarna.sobarnamovies.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.sobarna.sobarnamovies.sources.RemoteDataSource
import com.sobarna.sobarnamovies.utils.DataMoviesAndShow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieAndShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val repository = FakeMovieAndShowRepository(remote)

    private val movieDummy = DataMoviesAndShow.getMoviesDataDummy()
    private val showDummy = DataMoviesAndShow.getShowsDataDummy()

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieDummy)
            null
        }.`when`(remote).getMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(repository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieDummy.size.toLong(),movieEntities.size.toLong())

    }

    @Test
    fun getShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowCallback)
                .onAllShowReceived(showDummy)
            null
        }.`when`(remote).getShows(any())
        val showEntities = LiveDataTestUtil.getValue(repository.getShows())
        verify(remote).getShows(any())
        assertNotNull(showEntities)
        assertEquals(showDummy.size.toLong(),showEntities.size.toLong())
    }
}