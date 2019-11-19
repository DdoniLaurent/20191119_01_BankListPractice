package com.tioeun.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tioeun.a20191119_01_banklistpractice.datas.Bank

class MainActivity : BaseAcitivity() {

    var bankList = ArrayList<Bank>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }


    override fun setValues() {
        getBanksFromServer()
    }

    fun getBanksFromServer() {

    }
}
