package com.challange.homecards.data.repository

import com.challange.network.model.HearthstoneResponse
import retrofit2.Response

interface HeartStoneRepository {
    suspend fun getHeartStoneResponse(): Response<HearthstoneResponse>
}