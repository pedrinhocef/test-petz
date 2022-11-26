package com.challange.cache.homecards.repository

import com.challange.cache.init.ModuleHawk
import com.challange.network.model.HeartStoneRareResponseItem.Companion.HEART_STONE_RARE_CACHE_KEY
import com.challange.network.model.HeartStoneRareResponseItem

object HomeCardsCacheRep {

    fun addCardsCache(heartStoneRare: List<HeartStoneRareResponseItem>) {
        ModuleHawk.put(HEART_STONE_RARE_CACHE_KEY, heartStoneRare)
    }

    fun getCardsFromCache(): List<HeartStoneRareResponseItem>? = ModuleHawk.get(HEART_STONE_RARE_CACHE_KEY)

    fun deleteCardsCache () {
        if (ModuleHawk.contains(HEART_STONE_RARE_CACHE_KEY))
            ModuleHawk.delete(HEART_STONE_RARE_CACHE_KEY)
    }

}