package com.challange.homecards.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.challange.homecards.data.usecase.HeartStoneUseCase
import com.challange.homecards.helper.BaseViewModel
import com.challange.homecards.helper.Resource
import com.challange.network.model.BasicItem
import com.challange.network.model.HearthstoneResponse
import kotlinx.coroutines.launch

class HeartStoneViewModel(private val useCase: HeartStoneUseCase): BaseViewModel() {

    private val _heartStone = MutableLiveData<Resource<HearthstoneResponse>>()
    val heartStone: LiveData<Resource<HearthstoneResponse>>
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

    fun addCache(basicItem: List<BasicItem>) = useCase.addCache(basicItem)

    fun deleteCache() = useCase.deleteCache()

}