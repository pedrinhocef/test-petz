package com.challange.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MechanicsItem(
	val name: String
) : Parcelable