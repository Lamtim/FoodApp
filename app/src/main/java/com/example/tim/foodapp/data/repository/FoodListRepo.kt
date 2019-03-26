package com.example.tim.foodapp.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.tim.foodapp.data.local.FoodListLocalSource
import com.example.tim.foodapp.data.models.FoodList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodListRepo @Inject constructor(val foodListLocalSource: FoodListLocalSource) {


    fun getLists(): ArrayList<FoodList> {
        return getListsLocal()
    }

    fun getListsLocal(): ArrayList<FoodList> {
        return foodListLocalSource.getLists()
    }
}