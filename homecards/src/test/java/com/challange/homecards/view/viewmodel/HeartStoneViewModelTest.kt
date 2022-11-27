package com.challange.homecards.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.challange.homecards.data.usecase.HeartStoneUseCaseImpl
import com.challange.homecards.helper.Resource
import com.challange.network.model.HeartStoneRareResponseItem
import com.challange.network.model.MechanicsItem
import com.nhaarman.mockitokotlin2.doReturn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.amshove.kluent.shouldBeEqualTo
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.exceptions.base.MockitoException
import retrofit2.Response
import java.io.IOException


@ExperimentalCoroutinesApi
internal class HeartStoneViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private var useCaseMock =  Mockito.mock(HeartStoneUseCaseImpl::class.java)
    private lateinit var viewModel : HeartStoneViewModel


    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = HeartStoneViewModel(useCaseMock)
    }

    @After
    fun tearDown() {
        testCoroutineDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }

    @Test
    fun `should return success when call get heart stone live data` () = testCoroutineDispatcher.runBlockingTest {
        testCoroutineDispatcher.pauseDispatcher()

        doReturn(mockResponseSuccess()).`when`(useCaseMock).getHeartStoneResponseUseCase()

        viewModel.getHeartStoneResponse()

        testCoroutineDispatcher.resumeDispatcher()

        viewModel.heartStone.value.shouldBeEqualTo(Resource.success(listRareItems()))
    }

    @Test
    fun `testing getProducts response null error`() = testCoroutineDispatcher.runBlockingTest {
        testCoroutineDispatcher.pauseDispatcher()

        doReturn(mockResponseNull()).`when`(useCaseMock).getHeartStoneResponseUseCase()

        viewModel.getHeartStoneResponse()

        testCoroutineDispatcher.resumeDispatcher()

        viewModel.errorDataNull.value.shouldBeEqualTo(null)
    }

    @Test(expected = MockitoException::class)
    fun `testing getProducts response exception error`() = testCoroutineDispatcher.runBlockingTest {
        testCoroutineDispatcher.pauseDispatcher()

        Mockito.doThrow(IOException::class.java).`when`(useCaseMock).getHeartStoneResponseUseCase()

        viewModel.getHeartStoneResponse()

        testCoroutineDispatcher.resumeDispatcher()

        viewModel.heartStone.value.shouldBeEqualTo(Resource.error<HeartStoneRareResponseItem>(IOException()))
    }

    private fun listRareItems(): List<HeartStoneRareResponseItem> =
        arrayListOf(HeartStoneRareResponseItem(
            img = "", cost = 0, collectible = false, artist = "", faction = "",
            flavor = "", health = 0, mechanics = arrayListOf(MechanicsItem(name = "")),
            dbfId = 0, type = "", locale = "", playerClass = "", cardId = "", cardSet = "",
            attack = 0, name = "", imgGold = "", text = "", rarity = "", spellSchool = "",
            race = "", howToGet = "", howToGetGold = "", durability = 0, classes = arrayListOf(toString()),
            multiClassGroup = "", elite = false, armor = ""
        ))

    private fun mockResponseSuccess() = Response.success(listRareItems())

    private fun mockResponseNull() = null
}