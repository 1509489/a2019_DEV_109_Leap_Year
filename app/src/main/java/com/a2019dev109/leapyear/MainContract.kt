package com.a2019dev109.leapyear

interface MainContract {
    interface View{
        fun showIsLeapYearOrNot(isLeapYear: Boolean)
        fun showMessage(message: String)
    }
    interface Presenter{
        fun isLeapYear(year: String)
    }
}