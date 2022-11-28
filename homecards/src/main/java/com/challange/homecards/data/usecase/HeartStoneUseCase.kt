package com.challange.homecards.data.usecase

import com.challange.network.model.HeartStoneRareResponseItem
import retrofit2.Response

interface HeartStoneUseCase {
    suspend fun getHeartStoneResponseUseCase(): Response<List<HeartStoneRareResponseItem>>
    fun addCache(heartStoneRareItem: List<HeartStoneRareResponseItem>)
    fun deleteCache()
    fun getCache(): List<HeartStoneRareResponseItem>?
    fun filterList(heartStoneRareResponseItem: List<HeartStoneRareResponseItem>): List<HeartStoneRareResponseItem>
}