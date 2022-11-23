package com.challange.network.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class MarchOfTheLichKingItem(

	@field:SerializedName("img")
	val img: String? = null,

	@field:SerializedName("cost")
	val cost: Int? = null,

	@field:SerializedName("collectible")
	val collectible: Boolean? = null,

	@field:SerializedName("artist")
	val artist: String? = null,

	@field:SerializedName("dbfId")
	val dbfId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("howToGetGold")
	val howToGetGold: String? = null,

	@field:SerializedName("locale")
	val locale: String? = null,

	@field:SerializedName("flavor")
	val flavor: String? = null,

	@field:SerializedName("playerClass")
	val playerClass: String? = null,

	@field:SerializedName("elite")
	val elite: Boolean? = null,

	@field:SerializedName("cardSet")
	val cardSet: String? = null,

	@field:SerializedName("cardId")
	val cardId: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("rarity")
	val rarity: String? = null,

	@field:SerializedName("spellSchool")
	val spellSchool: String? = null
) : Parcelable