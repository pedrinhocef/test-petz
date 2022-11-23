package com.challange.homecards.helper

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected fun <T> MutableLiveData<Resource<T>>.success(data: T?) {
        postValue(Resource.success(data))
    }

    protected fun <T> MutableLiveData<Resource<T>>.error(e: Throwable?) {
        value = Resource.error(e)
    }

    protected fun <T> MutableLiveData<Resource<T>>.errorData(
        error: Throwable,
        `data`: T
    ) {
        value = Resource.errorData(error, data)
    }

    protected fun <T> MutableLiveData<Resource<T>>.loading(boolean: Boolean) {
        value = Resource.loading(boolean)
    }

    protected fun <T> SingleLiveEvent<Resource<T>>.singleLiveEventSuccess(data: T?) {
        postValue(Resource.success(data))
    }

    protected fun <T> SingleLiveEvent<Resource<T>>.singleLiveEventError(e: Throwable?) {
        value = Resource.error(e)
    }

    protected fun <T> SingleLiveEvent<Resource<T>>.singleLiveEventLoading(boolean: Boolean) {
        value = Resource.loading(boolean)
    }

    protected class DataError(
        val error: Throwable?,
        val `data`: Any
    ) : Throwable(error)
}