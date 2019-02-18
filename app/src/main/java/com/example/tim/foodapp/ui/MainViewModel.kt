package com.example.tim.foodapp.ui

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.tim.foodapp.data.repository.FoodRepo
import com.example.tim.foodapp.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(val foodRepo: FoodRepo) : BaseViewModel() {

    var productFound: MutableLiveData<String> = MutableLiveData()
    fun getProduct(barcode: String) {
        disposable = foodRepo.getProductByBarcode(barcode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> productFound.value = result.product?.productName },
                        { error -> Log.e("ERROR", error.message) }
                )
    }
}