package com.example.tim.foodapp.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.tim.foodapp.data.models.State
import com.example.tim.foodapp.data.repository.FoodRepo
import com.example.tim.foodapp.ui.base.BaseViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(val foodRepo: FoodRepo) : BaseViewModel() {

    // var productFound: MutableLiveData<String> = MutableLiveData()

    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String>
        get() = _imageUrl

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    fun getProduct(barcode: String) {
        disposable = foodRepo.getProductByBarcode(barcode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> processResult(result) },
                        { error -> Log.e("ERROR", error.message) }
                )
    }

    fun processResult(result: State) {

        when (result.status) {
            0 -> { // le produit n'est pas trouvé
                _result.value = result.statusVerbose
                _imageUrl.value = null
            }
            1 -> { // le produit est trouvé
                _result.value = result.product?.productName
                _imageUrl.value = result.product?.imageUrl
            }
        }
    }
}