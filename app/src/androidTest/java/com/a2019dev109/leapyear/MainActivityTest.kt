package com.a2019dev109.leapyear

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun showIsLeapYear(){
        val year = "2000"
        onView(withId(R.id.etYear)).perform(typeText(year), closeSoftKeyboard())
        onView(withId(R.id.btnCheck)).perform(click())
        onView(withId(R.id.tvMessage)).check(ViewAssertions.matches(withText("$year is a Leap Year")))
    }

    @Test
    fun showIsNotLeapYear(){
        val year = "2001"
        onView(withId(R.id.etYear)).perform(typeText(year), closeSoftKeyboard())
        onView(withId(R.id.btnCheck)).perform(click())
        onView(withId(R.id.tvMessage)).check(ViewAssertions.matches(withText("$year is not a Leap Year")))
    }
}