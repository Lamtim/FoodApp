package com.example.tim.foodapp.data.repository

import com.example.tim.foodapp.data.models.State
import com.example.tim.foodapp.data.services.FoodService
import io.reactivex.Observable
import javax.inject.Inject

class FoodRepo @Inject constructor(private val foodService: FoodService) {

    fun helloTest(): String {
        return "hello"
    }

    fun getProductByBarcode(barcode: String): Observable<State> = foodService.getProductByBarcode(barcode)

}