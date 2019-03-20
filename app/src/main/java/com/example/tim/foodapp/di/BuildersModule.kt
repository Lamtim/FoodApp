package com.example.tim.foodapp.di

import com.example.tim.foodapp.ui.FoodList.FoodListActivity
import com.example.tim.foodapp.ui.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindFoodListActivity(): FoodListActivity
}