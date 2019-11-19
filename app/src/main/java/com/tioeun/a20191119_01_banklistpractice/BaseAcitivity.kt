package com.tioeun.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseAcitivity : AppCompatActivity() {

    abstract fun setupEvents()

    abstract fun setValues()

    var mContext = this
}