package com.challange.network.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class MechanicsItem(

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable