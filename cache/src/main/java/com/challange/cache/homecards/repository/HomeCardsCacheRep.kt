package com.challange.cache.homecards.repository

import com.challange.cache.init.ModuleHawk
import com.challange.network.model.BasicItem

object HomeCardsCacheRep {

    fun addCardsCache(basicItem: BasicItem) {
        ModuleHawk.put(BasicItem.BASIC_ITEM_CACHE_KEY, basicItem)
    }

    fun getCardsFromCache(): BasicItem? = ModuleHawk.get(BasicItem.BASIC_ITEM_CACHE_KEY)

    fun deleteCardsCache () {
        if (ModuleHawk.contains(BasicItem.BASIC_ITEM_CACHE_KEY))
            ModuleHawk.delete(BasicItem.BASIC_ITEM_CACHE_KEY)
    }

}