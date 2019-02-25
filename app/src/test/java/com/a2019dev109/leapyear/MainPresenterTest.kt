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
    fun yearsDivisibleBy400AreLeapYear(){
        val years = arrayOf("1600","2000", "2400")

       for (year in years){
           mainPresenter.isLeapYear(year)
       }
        verify(view, times(years.size)).showIsLeapYearOrNot(true)
    }

    @Test
    fun yearsDivisibleBy100ButNot400NotLeapYear(){
        val years = arrayOf("1700", "1800", "1900", "2100")

        for (year in years){
            mainPresenter.isLeapYear(year)
        }
        verify(view, times(years.size)).showIsLeapYearOrNot(false)
    }

    @Test
    fun yearsDivisibleBy4ButNot100AreLeapYear(){
        val years = arrayOf("2008", "2012", "2016", "2004")

        for (year in years){
            mainPresenter.isLeapYear(year)
        }
        verify(view, times(years.size)).showIsLeapYearOrNot(true)
    }

    @Test
    fun yearsNotDivisibleBy4NotLeapYear(){
        val years = arrayOf("2017", "2018", "2019", "2021")

        for (year in years){
            mainPresenter.isLeapYear(year)
        }
        verify(view, times(years.size)).showIsLeapYearOrNot(false)
    }

    @Test
    fun isYearNegativeValue(){
        val years = arrayOf(-2004, -2019, -2000)

        for (year in years)
            mainPresenter.isLeapYear(year.toString())

        verify(view, times(years.size)).showIsLeapYearOrNot(false)
        verify(view, times(years.size)).showMessage("Year cannot be negative value")
    }

    @Test
    fun isYearValidLength(){
        val years = arrayOf(204, 20040)

        for (year in years)
            mainPresenter.isLeapYear(year.toString())

        verify(view, times(years.size)).showIsLeapYearOrNot(false)
        verify(view, times(years.size)).showMessage("Year is either too long or short. Year should be like: (2000 or 1901)")
    }
}