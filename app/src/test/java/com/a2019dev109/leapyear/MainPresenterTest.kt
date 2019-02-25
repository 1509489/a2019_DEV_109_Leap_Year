package com.a2019dev109.leapyear

import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {
    private lateinit var mainPresenter: MainPresenter

    @Mock lateinit var view: MainContract.View

    @Before
    fun setUp() {
        mainPresenter = MainPresenter(view)
    }

    @Test
    fun isLeapYear() {
    }

    @Test
    fun yearsDivisibleBy400IsLeapYear(){
        val years = arrayOf("1600","2000", "2400")

       for (year in years){
           mainPresenter.isLeapYear(year)
       }
        verify(view, times(years.size)).showIsLeapYearOrNot(true)
    }
}