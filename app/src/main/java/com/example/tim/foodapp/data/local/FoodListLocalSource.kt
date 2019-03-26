package com.example.tim.foodapp.data.local

import android.arch.lifecycle.LiveData
import com.example.tim.foodapp.data.models.FoodList
import io.reactivex.Flowable
import javax.inject.Inject

class FoodListLocalSource @Inject constructor(val foodListDao: FoodListDao) {

    fun getLists(): LiveData<List<FoodList>> {
        /*val list = ArrayList<FoodList>()
        for (i in 0..20)
            list.add(FoodList("salut Test$i", null))
        return list*/
        return foodListDao.getFoodLists()
    }

    fun addList(foodlist: FoodList) {
        foodListDao.insertFoodList(foodlist)

        Flowable.just("${foodlist.name} inserted").subscribe(System.out::println)
    }
}