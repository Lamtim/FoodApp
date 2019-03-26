package com.example.tim.foodapp.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.tim.foodapp.data.models.FoodList

@Dao
interface FoodListDao {

    @Query("SELECT * FROM foodlist")
    fun getAlarms(): LiveData<List<FoodList>>

    @Query("SELECT * FROM foodlist WHERE id=:id")
    fun getAlarm(id: Long): LiveData<FoodList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlarm(alarm: FoodList)

    @Update
    fun updateAlarm(alarm: FoodList)

    @Delete
    fun deleteAlarm(alarm: FoodList)

    @Query("DELETE FROM foodlist")
    fun deleteAll()


}