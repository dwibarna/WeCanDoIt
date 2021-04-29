package com.sobarna.sobarnamovies.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.sobarna.sobarnamovies.R
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest{

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkRecyclerMovie(){

        onView(withId(R.id.rvMovieList)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovieList)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(MovieAndShowViewModel().getListMovie().size))
    }
    @Test
    fun checkDetailMovieFirst(){

        onView(withId(R.id.rvMovieList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))

        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDirectorDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun checkDetailMovieLast(){

        onView(withId(R.id.rvMovieList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(MovieAndShowViewModel().getListMovie().lastIndex,click()))

        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDirectorDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun checkRecyclerShow(){
        onView(withId(R.id.rvMovieList)).perform(swipeLeft())
        onView(withId(R.id.rvTvShowList)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShowList)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(MovieAndShowViewModel().getListMovie().size))
    }

    @Test
    fun checkTvDetailFirst(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rvTvShowList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))

        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDirectorDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())

    }

    @Test
    fun checkDetailTvShowLast(){
        onView(withText("TV Show")).perform(click())

        onView(withId(R.id.rvTvShowList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(MovieAndShowViewModel().getListShow().lastIndex,click()))

        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDirectorDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())
    }
}