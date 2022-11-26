package com.challange.homecards.data.repository

import com.challange.network.model.HeartStoneRareResponseItem
import retrofit2.Response

interface HeartStoneRepository {
    suspend fun getHeartStoneResponse(): Response<List<HeartStoneRareResponseItem>>
}