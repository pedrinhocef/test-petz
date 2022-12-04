package com.challange.homecards.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.challange.homecards.data.usecase.HeartStoneUseCaseImpl
import com.challange.homecards.helper.Resource
import com.challange.homecards.view.viewmodel.utils.getOrAwaitValue
import com.challange.network.model.HeartStoneRareResponseItem
import com.nhaarman.mockitokotlin2.doReturn
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody
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
    private var useCaseMockK = mockk<HeartStoneUseCaseImpl>()
    private var useCaseMock =  Mockito.mock(HeartStoneUseCaseImpl::class.java)
    private lateinit var viewModel : HeartStoneViewModel
    private var listRareItems = mockk<List<HeartStoneRareResponseItem>>()


    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = HeartStoneViewModel(useCaseMockK)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should return success when call get heart stone live data` () = runTest {

        coEvery { useCaseMockK.getHeartStoneResponseUseCase() } returns mockResponseSuccess()

        viewModel.getHeartStoneResponse()

        viewModel.heartStone.getOrAwaitValue().shouldBeEqualTo(Resource.success(listRareItems))
    }

    @Test
    fun `should filtering a valid list when called` () = runTest {
        every { useCaseMockK.filterList(listRareItems) } returns listRareItems

        viewModel.filteringListOnlyValidImages(listRareItems)

        verify (exactly = 1) { useCaseMockK.filterList(listRareItems) }
    }

    @Test
    fun `should return null when call get heart and response is null`() = runTest {

        doReturn(mockResponseNull()).`when`(useCaseMock).getHeartStoneResponseUseCase()

        viewModel.getHeartStoneResponse()

        viewModel.errorDataNull.value.shouldBeEqualTo(null)
    }


    @Test
    fun `should return a list from cache when call getCache`() = runTest {

        coEvery { useCaseMockK.getCache() } returns listRareItems

        viewModel.getHeartStoneCacheCache()

        verify (exactly = 1) { viewModel.getHeartStoneCacheCache() }
    }

    @Test
    fun `should add a list to cache when call add cache`() = runTest {

        coEvery { useCaseMockK.addCache(listRareItems) } returns (Unit)

        viewModel.addCache(listRareItems)

        verify (exactly = 1) { viewModel.addCache(listRareItems) }
    }


    @Test
    fun `should delete a list from cache when call delete cache`() = runTest {

        coEvery { useCaseMockK.deleteCache() } returns (Unit)

        viewModel.deleteCache()

        verify (exactly = 1) { viewModel.deleteCache() }
    }

    @Test(expected = MockitoException::class)
    fun `should return IOException when call get heart`() = runTest {

        Mockito.doThrow(IOException::class.java).`when`(useCaseMock).getHeartStoneResponseUseCase()

        viewModel.getHeartStoneResponse()

        viewModel.heartStone.getOrAwaitValue().shouldBeEqualTo(Resource.error<HeartStoneRareResponseItem>(IOException()))
    }

    private fun mockResponseSuccess() = Response.success(listRareItems)

    private fun mockResponseNull(): ResponseBody? = null
}