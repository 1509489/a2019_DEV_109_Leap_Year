package com.a2019dev109.leapyear

class MainPresenter(private val view: MainContract.View): MainContract.Presenter {

    override fun isLeapYear(year: String) {
        if (year.toInt() < 0){
            view.showMessage("Year cannot be negative value")
            view.showIsLeapYearOrNot(false)
        }
        else{
            when {
                year.toInt() % 400 == 0 -> view.showIsLeapYearOrNot(true)
                year.toInt() % 4 == 0 && year.toInt() % 100 != 0 -> view.showIsLeapYearOrNot(true)
                else -> view.showIsLeapYearOrNot(false)
            }
        }
    }
}