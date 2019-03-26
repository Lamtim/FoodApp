package com.example.tim.foodapp.ui.FoodList

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.tim.foodapp.data.models.FoodList
import com.example.tim.foodapp.data.repository.FoodListRepo
import com.example.tim.foodapp.ui.base.BaseViewModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject
import io.reactivex.schedulers.Schedulers


class FoodListViewModel @Inject constructor(val foodListRepo: FoodListRepo) : BaseViewModel() {

    private val _lists = MutableLiveData<List<FoodList>>()
    /*val lists: LiveData<List<FoodList>>
        get() = _lists
*/

    val lists: LiveData<List<FoodList>>?
        get() {
            return foodListRepo.getLists()
        }

    fun addList(foodList: FoodList) {
        /*val list = ArrayList<FoodList>()
        for (fl in _lists.value!!)
            list.add(fl)
        list.add(foodList)
        _lists.value = list*/
        Flowable.just("Obeservable called").subscribe(System.out::println)
        Observable.fromCallable { foodListRepo.addFoodList(foodList) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(
                        { result -> Log.d("GOOD", "observable finished") },
                        { error -> Log.e("ERROR", error.message) }
                )

    }


    /*fun getList() {
        _lists.value = foodListRepo.getLists()
    }*/

}