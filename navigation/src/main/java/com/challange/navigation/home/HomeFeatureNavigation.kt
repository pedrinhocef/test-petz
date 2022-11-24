package com.challange.navigation.home

import android.content.Context
import com.challange.navigation.utils.IntentUtils

object HomeFeatureNavigation {

    private const val HOME_PACKAGE: String = "com.challange.homecards.view.ui"

    fun openHeartStoneFeatureNavigation(context: Context) {
        IntentUtils.openFeatureIntent(
            context,
            "$HOME_PACKAGE.HeartStoneActivity"
        )
    }

}