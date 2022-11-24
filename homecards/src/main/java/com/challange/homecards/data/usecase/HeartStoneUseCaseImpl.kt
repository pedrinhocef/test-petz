package com.challange.homecards.data.usecase

import com.challange.cache.homecards.repository.HomeCardsCacheRep
import com.challange.homecards.data.repository.HeartStoneRepository
import com.challange.network.model.BasicItem
import com.challange.network.model.HearthstoneResponse
import retrofit2.Response

class HeartStoneUseCaseImpl(
    private val repository: HeartStoneRepository,
    private val cache: HomeCardsCacheRep
): HeartStoneUseCase {

    override suspend fun getHeartStoneResponseUseCase(): Response<HearthstoneResponse> {
        return repository.getHeartStoneResponse()
    }

    override fun addCache(basicItemList: List<BasicItem>) {
       cache.addCardsCache(basicItemList)
    }

    override fun deleteCache() {
        cache.deleteCardsCache()
    }

    override fun getCache(): List<BasicItem>? {
        return cache.getCardsFromCache()
    }

}