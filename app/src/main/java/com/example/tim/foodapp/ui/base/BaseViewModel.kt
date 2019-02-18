package com.example.tim.foodapp.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.tim.foodapp.data.models.ErrorData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    val loader: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<ErrorData?> = MutableLiveData()
    var disposable: Disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
    }
}