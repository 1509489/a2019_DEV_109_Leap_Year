package com.a2019dev109.leapyear

class MainPresenter(private val view: MainContract.View): MainContract.Presenter {
    private var validInput = false

    override fun isLeapYear(year: String) {
        if (year.toInt() < 0){
            view.showMessage("Year cannot be negative value")
            view.showIsLeapYearOrNot(false)
            validInput = false
        }
        else if (year.length < 4 || year.length > 4){
            view.showMessage("Year is either too long or short. Year should be like: (2000 or 1901)")
            view.showIsLeapYearOrNot(false)
            validInput = false
        }
        else{
            validInput = true
            when {
                year.toInt() % 400 == 0 -> view.showIsLeapYearOrNot(true)
                year.toInt() % 4 == 0 && year.toInt() % 100 != 0 -> view.showIsLeapYearOrNot(true)
                else -> view.showIsLeapYearOrNot(false)
            }
        }
    }

    fun isValidInput():Boolean = validInput
}