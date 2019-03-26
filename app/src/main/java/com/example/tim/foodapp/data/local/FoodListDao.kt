package com.example.tim.foodapp.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.tim.foodapp.data.models.FoodList
import io.reactivex.Completable

@Dao
interface FoodListDao {

    @Query("SELECT * FROM foodlist")
    fun getFoodLists(): LiveData<List<FoodList>>

    @Query("SELECT * FROM foodlist WHERE id=:id")
    fun getFoodList(id: Long): LiveData<FoodList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFoodList(foodList: FoodList)

    @Update
    fun updateFoodList(foodList: FoodList)

    @Delete
    fun deleteFoodList(foodList: FoodList)

    @Query("DELETE FROM foodlist")
    fun deleteAll()


}