package com.example.tim.foodapp.di

import android.arch.persistence.room.Room
import android.content.Context
import com.example.tim.foodapp.data.local.AppDatabase
import com.example.tim.foodapp.data.local.FoodListDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    //Room Module
    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "foodapp.db")
                .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideFoodListDao(db: AppDatabase): FoodListDao {
        return db.foodListDao()
    }

}