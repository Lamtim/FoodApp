package com.example.tim.foodapp.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.tim.foodapp.data.local.FoodListLocalSource
import com.example.tim.foodapp.data.models.FoodList
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodListRepo @Inject constructor(val foodListLocalSource: FoodListLocalSource) {


    fun getLists(): LiveData<List<FoodList>> {
        return getListsLocal()
    }

    fun addFoodList(foodList: FoodList){

        Flowable.just("addFoodList").subscribe(System.out::println)
        addFoodListLocal(foodList)
    }


    private fun getListsLocal(): LiveData<List<FoodList>> {
        return foodListLocalSource.getLists()
    }

    private fun addFoodListLocal(foodList: FoodList){
        foodListLocalSource.addList(foodList)
    }
}