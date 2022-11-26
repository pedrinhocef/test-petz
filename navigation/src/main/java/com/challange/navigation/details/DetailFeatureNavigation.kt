package com.challange.navigation.details

import android.content.Context
import com.challange.navigation.utils.IntentUtils
import com.challange.network.model.HeartStoneRareResponseItem

object DetailFeatureNavigation {

    private const val DETAIL_PACKAGE: String = "com.challange.homecards.view.ui"
    private const val EXTRA_BASIC_ITEM: String = "basicItem"

    fun openDetailsFeatureNavigation(context: Context, heartStoneRareResponse: HeartStoneRareResponseItem) {
        IntentUtils.openFeatureIntent(
            context,
            "$DETAIL_PACKAGE.DetailsActivity"
        ) {
            putExtra(EXTRA_BASIC_ITEM, heartStoneRareResponse)
        }
    }
}