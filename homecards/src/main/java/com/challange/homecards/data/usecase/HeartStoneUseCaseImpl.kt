package com.challange.homecards.data.usecase

import com.challange.cache.homecards.repository.HomeCardsCacheRep
import com.challange.homecards.data.repository.HeartStoneRepository
import com.challange.network.model.HeartStoneRareResponseItem
import retrofit2.Response

class HeartStoneUseCaseImpl(
    private val repository: HeartStoneRepository,
    private val cache: HomeCardsCacheRep
): HeartStoneUseCase {

    override suspend fun getHeartStoneResponseUseCase(): Response<List<HeartStoneRareResponseItem>> {
        return repository.getHeartStoneResponse()
    }

    override fun addCache(heartStoneRareItem: List<HeartStoneRareResponseItem>) {
       cache.addCardsCache(heartStoneRareItem)
    }

    override fun deleteCache() {
        cache.deleteCardsCache()
    }

    override fun getCache(): List<HeartStoneRareResponseItem>? {
        return cache.getCardsFromCache()
    }

}