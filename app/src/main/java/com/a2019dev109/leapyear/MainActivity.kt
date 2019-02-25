package com.a2019dev109.leapyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showIsLeapYearOrNot(isLeapYear: Boolean) {

    }

    override fun showMessage(message: String) {

    }

    fun onCheckYear(view: View){

    }
}
