package com.a2019dev109.leapyear

class MainPresenter(private val view: MainContract.View): MainContract.Presenter {

    override fun isLeapYear(year: String) {
        if (year.toInt() % 400 == 0){
            view.showIsLeapYearOrNot(true)
        }
    }
}