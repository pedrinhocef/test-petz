package com.challange.navigation.details

import android.content.Context
import com.challange.navigation.utils.IntentUtils
import com.challange.network.model.HeartStoneRareResponseItem

object DetailFeatureNavigation {

    private const val DETAIL_PACKAGE: String = "com.challange.homecards.view.ui"
    const val EXTRA_RARE_ITEM: String = "basicItem"

    fun openDetailsFeatureNavigation(context: Context, heartStoneRareResponse: HeartStoneRareResponseItem) {
        IntentUtils.openFeatureIntent(
            context,
            "$DETAIL_PACKAGE.DetailsActivity"
        ) {
            putExtra(EXTRA_RARE_ITEM, heartStoneRareResponse)
        }
    }
}