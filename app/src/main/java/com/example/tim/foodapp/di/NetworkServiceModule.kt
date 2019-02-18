package com.example.tim.foodapp.di

import com.example.tim.foodapp.data.services.FoodService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [
    NetworkModule::class
])
class NetworkServiceModule {

    @Provides
    @Singleton
    fun provideFoodService(retrofit: Retrofit): FoodService {
        return retrofit.create(FoodService::class.java)
    }

}