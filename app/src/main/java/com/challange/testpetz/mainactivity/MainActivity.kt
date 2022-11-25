package com.challange.testpetz.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.challange.navigation.home.HomeFeatureNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeFeatureNavigation.openHeartStoneFeatureNavigation(this)
    }

}