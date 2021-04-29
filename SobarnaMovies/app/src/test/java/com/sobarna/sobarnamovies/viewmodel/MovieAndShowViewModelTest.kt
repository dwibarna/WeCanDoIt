package com.sobarna.sobarnamovies.viewmodel

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class MovieAndShowViewModelTest {

    private lateinit var movieAndShowViewModel: MovieAndShowViewModel
    @Before
    fun before(){
        movieAndShowViewModel = MovieAndShowViewModel()
    }
    @Test
    fun getListShow() {
        val collectionSize = 20

        assertEquals("Mencocokan jumlah size show yang asli",collectionSize,movieAndShowViewModel.getListShow().size)
        val onTheFunction = movieAndShowViewModel.getListShow().first()
        val firstTitle = "Arrow"
        val lastTitle = "The Walking Dead"

        assertEquals("mencocokan judul pertama pada list",firstTitle,onTheFunction.showTitle)
        assertEquals("mencocokan judul terakhir pada list",lastTitle,movieAndShowViewModel.getListShow().last().showTitle)
        
    }

    @Test
    fun getListMovie() {
        val collectionSize = 19
        val onTheFunction = movieAndShowViewModel.getListMovie().size
        assertEquals("mencocokan jumlah size movie",collectionSize,onTheFunction)
        val firstTitle = "A Star Is Born"
        val lasTitle = "T-34"
        assertEquals("mencocokan judul pertama pada list",firstTitle,movieAndShowViewModel.getListMovie().first().movieTitle)
        assertEquals("mencocokan judul terakhir pada list",lasTitle,movieAndShowViewModel.getListMovie().last().movieTitle)

    }
}