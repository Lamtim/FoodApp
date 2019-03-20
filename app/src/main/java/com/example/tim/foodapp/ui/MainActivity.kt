package com.example.tim.foodapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
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

        tips.text = "try\n 3029330003533\n 3095758857010"
        Flowable.just("salut").subscribe(System.out::println)

        get_product.setOnClickListener {
            mMainViewModel.getProduct(barcode.text.toString())
        }

        mMainViewModel.result.observe(this,
                Observer {
                    product.text = it
                })
        mMainViewModel.imageUrl.observe(this,
                Observer {
                    productImage.visibility = if (it != null) ImageView.VISIBLE else ImageView.GONE
                    Glide.with(this).load(it).centerCrop().into(productImage)
                })
    }
}
