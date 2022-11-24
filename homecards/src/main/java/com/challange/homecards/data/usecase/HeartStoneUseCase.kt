package com.challange.homecards.data.usecase

import com.challange.network.model.BasicItem
import com.challange.network.model.HearthstoneResponse
import retrofit2.Response

interface HeartStoneUseCase {
    suspend fun getHeartStoneResponseUseCase(): Response<HearthstoneResponse>
    fun addCache(basicItemList: List<BasicItem>)
    fun deleteCache()
    fun getCache(): List<BasicItem>?
}