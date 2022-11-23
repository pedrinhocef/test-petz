package com.challange.network.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class MissionsItem(

    @field:SerializedName("cost")
	val cost: Int? = null,

    @field:SerializedName("artist")
	val artist: String? = null,

    @field:SerializedName("health")
	val health: Int? = null,

    @field:SerializedName("mechanics")
	val mechanics: List<MechanicsItem?>? = null,

    @field:SerializedName("dbfId")
	val dbfId: Int? = null,

    @field:SerializedName("type")
	val type: String? = null,

    @field:SerializedName("locale")
	val locale: String? = null,

    @field:SerializedName("flavor")
	val flavor: String? = null,

    @field:SerializedName("playerClass")
	val playerClass: String? = null,

    @field:SerializedName("cardSet")
	val cardSet: String? = null,

    @field:SerializedName("attack")
	val attack: Int? = null,

    @field:SerializedName("cardId")
	val cardId: String? = null,

    @field:SerializedName("faction")
	val faction: String? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("text")
	val text: String? = null,

    @field:SerializedName("rarity")
	val rarity: String? = null,

    @field:SerializedName("durability")
	val durability: Int? = null,

    @field:SerializedName("spellSchool")
	val spellSchool: String? = null,

    @field:SerializedName("race")
	val race: String? = null
) : Parcelable