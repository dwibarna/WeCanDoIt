package com.sobarna.sobarnamovies.view

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.sobarna.sobarnamovies.R
import com.sobarna.sobarnamovies.utils.DataMoviesAndShow
import com.sobarna.sobarnamovies.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest{

    private lateinit var context:Context
    private val movieDummy = DataMoviesAndShow.getMoviesDataDummy()
    private val showDummy = DataMoviesAndShow.getShowsDataDummy()

    @Before
    fun setUp(){
        context = InstrumentationRegistry.getInstrumentation().targetContext
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingForActivity())
    }
    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingForActivity())
    }


    @Test
    fun checkRecyclerMovie(){

        onView(withId(R.id.rvMovieList)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovieList)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieDummy.size))

    }
    @Test
    fun checkDetailMovieFirst(){

        onView(withId(R.id.rvMovieList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.ivAvatarDetail)).perform(swipeUp())
        onView(withId(R.id.tvAverageDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvPopularityDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun checkDetailMovieLast(){

        onView(withId(R.id.rvMovieList)).perform(swipeUp())
        onView(withId(R.id.rvMovieList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(movieDummy.lastIndex,click()))

        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.ivAvatarDetail)).perform(swipeUp())
        onView(withId(R.id.tvAverageDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvPopularityDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun checkRecyclerShow(){


        onView(withId(R.id.rvMovieList)).perform(swipeLeft())
        onView(withId(R.id.rvTvShowList)).check(matches(isDisplayed()))

        onView(withId(R.id.rvTvShowList)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(showDummy.size))
    }

    @Test
    fun checkTvDetailFirst(){


        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rvTvShowList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))

        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.ivAvatarDetail)).perform(swipeUp())
        onView(withId(R.id.tvAverageDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvPopularityDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())

    }

    @Test
    fun checkDetailTvShowLast(){

        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rvTvShowList)).perform(swipeUp())

        onView(withId(R.id.rvTvShowList)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(showDummy.lastIndex,click()))

        onView(withId(R.id.ivAvatarDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.ivAvatarDetail)).perform(swipeUp())
        onView(withId(R.id.tvAverageDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvPopularityDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))

        onView(isRoot()).perform(pressBack())
    }
}