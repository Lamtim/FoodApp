package com.example.tim.foodapp.data.services

import com.example.tim.foodapp.data.models.State
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodService {

    @GET("api/v0/produits/{barcode}.json")
    fun getProductByBarcode(@Path("barcode") barcode: String): Observable<State>
}