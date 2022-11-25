package com.challange.navigation.details

import android.content.Context
import com.challange.navigation.utils.IntentUtils

object DetailFeatureNavigation {

    private const val DETAIL_PACKAGE: String = "com.challange.homecards.view.ui"

    fun openDetailsFeatureNavigation(context: Context) {
        IntentUtils.openFeatureIntent(
            context,
            "$DETAIL_PACKAGE.DetailsActivity"
        )
    }
}