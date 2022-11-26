package com.challange.homecards.data.repository

import com.challange.network.model.HeartStoneRareResponseItem
import com.challange.network.service.HearthstoneService
import retrofit2.Response

class HeartStoneRepositoryImpl(private val hearthstoneService: HearthstoneService) :
    HeartStoneRepository {

    override suspend fun getHeartStoneResponse(): Response<List<HeartStoneRareResponseItem>> {
        return hearthstoneService.service.getHearthStone()
    }

}