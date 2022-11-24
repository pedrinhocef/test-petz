package com.challange.homecards.data.repository

import com.challange.network.model.HearthstoneResponse
import com.challange.network.service.HearthstoneService
import retrofit2.Response

class HeartStoneRepositoryImpl(private val hearthstoneService: HearthstoneService) :
    HeartStoneRepository {

    override suspend fun getHeartStoneResponse(): Response<HearthstoneResponse> {
        return hearthstoneService.service.getHearthStone()
    }

}