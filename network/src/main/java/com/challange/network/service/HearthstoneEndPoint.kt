package com.challange.network.service

import com.challange.network.model.HearthstoneResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface HearthstoneEndPoint {
    @Headers(
        "X-RapidAPI-Key: ea754243a5msh6fd228f4d3d0b68p1df514jsn4554480dfe54",
        "X-RapidAPI-Host: omgvamp-hearthstone-v1.p.rapidapi.com"
    )
    @GET("cards")
    suspend fun getHearthStone(): Response<HearthstoneResponse>
}