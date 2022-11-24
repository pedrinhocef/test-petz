package com.challange.homecards.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.challange.homecards.di.HeartStoneComponent

class HeartStoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HeartStoneComponent.inject()
    }
}