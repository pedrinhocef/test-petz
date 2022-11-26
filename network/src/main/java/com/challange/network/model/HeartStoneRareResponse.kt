package com.challange.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeartStoneRareResponse(
	val heartStoneRareResponse: List<HeartStoneRareResponseItem>? = arrayListOf()
) : Parcelable