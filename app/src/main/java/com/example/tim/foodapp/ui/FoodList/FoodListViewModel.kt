package com.example.tim.foodapp.ui.FoodList

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.tim.foodapp.data.models.FoodList
import com.example.tim.foodapp.ui.base.BaseViewModel
import javax.inject.Inject

class FoodListViewModel @Inject constructor() : BaseViewModel() {

    private val _lists = MutableLiveData<List<FoodList>>()
    val lists: LiveData<List<FoodList>>
        get() = _lists

    fun addList(foodList: FoodList) {
        val list = ArrayList<FoodList>()
        for (fl in _lists.value!!)
            list.add(fl)
        list.add(foodList)
        _lists.value = list
    }

    fun getList(){
        val list1 = FoodList("salut Test",null)
        val list = ArrayList<FoodList>()
        list.add(list1)
        _lists.value = list
    }

}