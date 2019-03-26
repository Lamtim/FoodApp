package com.example.tim.foodapp.data.local

import com.example.tim.foodapp.data.models.FoodList
import javax.inject.Inject

class FoodListLocalSource @Inject constructor(){

    fun getLists() : ArrayList<FoodList>{
        val list = ArrayList<FoodList>()
        for (i in 0..20)
            list.add(FoodList("salut Test$i"))
        return list
    }
}