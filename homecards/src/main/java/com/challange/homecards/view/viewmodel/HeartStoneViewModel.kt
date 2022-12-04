package com.challange.homecards.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.challange.homecards.data.usecase.HeartStoneUseCase
import com.challange.homecards.helper.BaseViewModel
import com.challange.homecards.helper.Resource
import com.challange.network.model.HeartStoneRareResponseItem
import kotlinx.coroutines.launch

internal class HeartStoneViewModel(private val useCase: HeartStoneUseCase): BaseViewModel() {

    private val _heartStone = MutableLiveData<Resource<List<HeartStoneRareResponseItem>>>()
    val heartStone: LiveData<Resource<List<HeartStoneRareResponseItem>>>
        get() = _heartStone

    private val _errorDataNull = MutableLiveData<Boolean>()
    val errorDataNull: LiveData<Boolean>
        get() = _errorDataNull

    fun getHeartStoneResponse() {
        viewModelScope.launch {
            val response = useCase.getHeartStoneResponseUseCase()

            if (response.isSuccessful && response.code() == 200){
                _heartStone.success(response.body())
            } else {
                _errorDataNull.value = true
            }
        }
    }

    fun getHeartStoneCacheCache() = useCase.getCache()

    fun addCache(heartStoneRareItem: List<HeartStoneRareResponseItem>) = useCase.addCache(heartStoneRareItem)

    fun deleteCache() = useCase.deleteCache()

    fun filteringListOnlyValidImages(heartStoneRareResponseItem: List<HeartStoneRareResponseItem>) = useCase.filterList(heartStoneRareResponseItem)

}