package com.example.tim.foodapp.ui.FoodList

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.tim.foodapp.data.models.FoodList
import com.example.tim.foodapp.data.repository.FoodListRepo
import com.example.tim.foodapp.ui.base.BaseViewModel
import javax.inject.Inject

class FoodListViewModel @Inject constructor(val foodListRepo: FoodListRepo) : BaseViewModel() {

    private val _lists = MutableLiveData<ArrayList<FoodList>>()
    val lists: LiveData<ArrayList<FoodList>>
        get() = _lists

    fun addList(foodList: FoodList) {
        val list = ArrayList<FoodList>()
        for (fl in _lists.value!!)
            list.add(fl)
        list.add(foodList)
        _lists.value = list
    }

    fun getList() {
        _lists.value = foodListRepo.getLists()
    }

}