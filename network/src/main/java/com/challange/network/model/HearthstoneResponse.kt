package com.challange.network.model

import android.os.Parcelable
import com.challange.network.*
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HearthstoneResponse(

    @field:SerializedName("Basic")
	val basic: List<BasicItem> = emptyList(),

    @field:SerializedName("Knights of the Frozen Throne")
	val knightsOfTheFrozenThrone: List<KnightsOfTheFrozenThroneItem?>? = null,

    @field:SerializedName("Whispers of the Old Gods")
	val whispersOfTheOldGods: List<WhispersOfTheOldGodsItem?>? = null,

    @field:SerializedName("Battlegrounds")
	val battlegrounds: List<BattlegroundsItem?>? = null,

    @field:SerializedName("Legacy")
	val legacy: List<LegacyItem?>? = null,

    @field:SerializedName("Vanilla")
	val vanilla: List<VanillaItem?>? = null,

    @field:SerializedName("Saviors of Uldum")
	val saviorsOfUldum: List<SaviorsOfUldumItem?>? = null,

    @field:SerializedName("Naxxramas")
	val naxxramas: List<NaxxramasItem?>? = null,

    @field:SerializedName("Hero Skins")
	val heroSkins: List<HeroSkinsItem?>? = null,

    @field:SerializedName("The Boomsday Project")
	val theBoomsdayProject: List<TheBoomsdayProjectItem?>? = null,

    @field:SerializedName("Mercenaries")
	val mercenaries: List<MercenariesItem?>? = null,

    @field:SerializedName("Unknown")
	val unknown: List<UnknownItem?>? = null,

    @field:SerializedName("Scholomance Academy")
	val scholomanceAcademy: List<ScholomanceAcademyItem?>? = null,

    @field:SerializedName("Madness At The Darkmoon Faire")
	val madnessAtTheDarkmoonFaire: List<MadnessAtTheDarkmoonFaireItem?>? = null,

    @field:SerializedName("Descent of Dragons")
	val descentOfDragons: List<DescentOfDragonsItem?>? = null,

    @field:SerializedName("Goblins vs Gnomes")
	val goblinsVsGnomes: List<GoblinsVsGnomesItem?>? = null,

    @field:SerializedName("Core")
	val core: List<CoreItem?>? = null,

    @field:SerializedName("Galakrond's Awakening")
	val galakrondSAwakening: List<GalakrondSAwakeningItem?>? = null,

    @field:SerializedName("Demon Hunter Initiate")
	val demonHunterInitiate: List<DemonHunterInitiateItem?>? = null,

    @field:SerializedName("United in Stormwind")
	val unitedInStormwind: List<UnitedInStormwindItem?>? = null,

    @field:SerializedName("Kobolds & Catacombs")
	val koboldsCatacombs: List<KoboldsCatacombsItem?>? = null,

    @field:SerializedName("The Witchwood")
	val theWitchwood: List<TheWitchwoodItem?>? = null,

    @field:SerializedName("The Grand Tournament")
	val theGrandTournament: List<TheGrandTournamentItem?>? = null,

    @field:SerializedName("Murder at Castle Nathria")
	val murderAtCastleNathria: List<MurderAtCastleNathriaItem?>? = null,

    @field:SerializedName("Taverns of Time")
	val tavernsOfTime: List<TavernsOfTimeItem?>? = null,

    @field:SerializedName("Classic")
	val classic: List<ClassicItem?>? = null,

    @field:SerializedName("Missions")
	val missions: List<MissionsItem?>? = null,

    @field:SerializedName("Blackrock Mountain")
	val blackrockMountain: List<BlackrockMountainItem?>? = null,

    @field:SerializedName("Journey to Un'Goro")
	val journeyToUnGoro: List<JourneyToUnGoroItem?>? = null,

    @field:SerializedName("Forged in the Barrens")
	val forgedInTheBarrens: List<ForgedInTheBarrensItem?>? = null,

    @field:SerializedName("Rise of Shadows")
	val riseOfShadows: List<RiseOfShadowsItem?>? = null,

    @field:SerializedName("One Night in Karazhan")
	val oneNightInKarazhan: List<OneNightInKarazhanItem?>? = null,

    @field:SerializedName("Tavern Brawl")
	val tavernBrawl: List<TavernBrawlItem?>? = null,

    @field:SerializedName("Rastakhan's Rumble")
	val rastakhanSRumble: List<RastakhanSRumbleItem?>? = null,

    @field:SerializedName("Hall of Fame")
	val hallOfFame: List<HallOfFameItem?>? = null,

    @field:SerializedName("Credits")
	val credits: List<CreditsItem?>? = null,

    @field:SerializedName("March of the Lich King")
	val marchOfTheLichKing: List<MarchOfTheLichKingItem?>? = null,

    @field:SerializedName("Fractured in Alterac Valley")
	val fracturedInAlteracValley: List<FracturedInAlteracValleyItem?>? = null,

    @field:SerializedName("Voyage to the Sunken City")
	val voyageToTheSunkenCity: List<VoyageToTheSunkenCityItem?>? = null,

    @field:SerializedName("The League of Explorers")
	val theLeagueOfExplorers: List<TheLeagueOfExplorersItem?>? = null,

    @field:SerializedName("Mean Streets of Gadgetzan")
	val meanStreetsOfGadgetzan: List<MeanStreetsOfGadgetzanItem?>? = null,

    @field:SerializedName("Ashes of Outland")
	val ashesOfOutland: List<AshesOfOutlandItem?>? = null
) : Parcelable