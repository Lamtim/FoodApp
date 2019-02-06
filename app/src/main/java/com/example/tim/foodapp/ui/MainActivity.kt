package com.example.tim.foodapp.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tim.foodapp.R
import com.example.tim.foodapp.ViewModelProviderFactory
import io.reactivex.Flowable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel = ViewModelProviders.of(this, mViewModelProviderFactory).get(MainViewModel::class.java)

        Flowable.just("salut").subscribe(System.out::println)
    }
}
