package com.a2019dev109.leapyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
    }

    override fun showIsLeapYearOrNot(isLeapYear: Boolean) {
        val message: String
        val year = etYear.text.toString()

        if (isLeapYear){
            message = "$year ${resources.getString(R.string.is_leap_year)}"
            tvMessage.text = message
        }
        else{
            message = "$year ${resources.getString(R.string.not_leap_year)}"
            tvMessage.text = message
        }
    }

    override fun showMessage(message: String) {
        if (!mainPresenter.isValidInput())
            tvMessage.text = message
    }

    fun onCheckYear(view: View){
        when(view.id){
            R.id.btnCheck ->{
                val year = etYear.text.toString()
                mainPresenter.isLeapYear(year)
                etYear.onEditorAction(EditorInfo.IME_ACTION_DONE)
            }
        }
    }
}
