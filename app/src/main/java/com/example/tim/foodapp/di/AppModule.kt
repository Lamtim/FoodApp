package com.example.tim.foodapp.di

import android.content.Context
import com.example.tim.foodapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ViewModelModule::class
])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

}