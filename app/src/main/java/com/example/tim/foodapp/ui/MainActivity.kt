package com.example.tim.foodapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.tim.foodapp.R
import com.example.tim.foodapp.ui.base.BaseActivity
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    val BARCODE: String = "3029330003533"

    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProvider.Factory
    lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel = ViewModelProviders.of(this, mViewModelProviderFactory).get(MainViewModel::class.java)

        Flowable.just("salut").subscribe(System.out::println)

        get_product.setOnClickListener {
            mMainViewModel.getProduct(BARCODE)
        }

        mMainViewModel.productFound.observe(this,
                Observer {
                    product.text = it
                })
    }
}
